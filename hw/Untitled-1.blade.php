@if (!empty($data) && count($data) > 0)

    {{-- Header --}}
    <div class="card-header bg-white">
        <div class="d-flex justify-content-between align-items-center">
            <h4 class="mb-0 text-primary pt-2">@lang('home.detailed_response')</h4>
            <div>
                <button id="print_response" class="btn btn-sm btn-primary me-2">
                    <i class="fas fa-print me-1"></i> @lang('home.print')
                </button>
                <a href="{{ route('response') }}" class="btn btn-sm btn-outline-secondary">
                    <i class="fas fa-arrow-left me-1"></i> @lang('home.back')
                </a>
            </div>
        </div>
    </div>

    {{-- Summary cards --}}
    <div class="row mb-4 mt-2">
        <div class="col-lg-3 col-md-6">
            <div class="p-3 border rounded">
                <div class="text-muted small">@lang('home.name')</div>
                <div class="h5 mb-0">
                    {{ translateHelper($data[0]->evaluator_id, 'person_name_kh', 'person_name_kh') ?? 'N/A' }}
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="p-3 border rounded">
                <div class="text-muted small">សាលា</div>
                <div class="h5 mb-0">{{ data_get($data[0], 'evaluator_id.entity', 'N/A') }}</div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="p-3 border rounded">
                <div class="text-muted small">@lang('home.date')</div>
                <div class="h5 mb-0">
                    {{ dbDate(data_get($data[0], 'evaluator_id.start_date')) }}
                    -
                    {{ dbDate(data_get($data[0], 'evaluator_id.end_date')) }}
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="p-3 border rounded">
                <div class="text-muted small">@lang('home.total_score')</div>
                <div class="h5 mb-0">{{ $totalScore }}/{{ $maxScore }}</div>
            </div>
        </div>
    </div>

    {{-- Topic header --}}
    <div class="section-header align-items-center mb-4">
        <h5 class="section-title mb-0 text-primary">
            {{ data_get($data[0], 'eval_topic_id.eval_topic', '-') }}
        </h5>
        @if (!empty(data_get($data[0], 'eval_topic_id.description')))
            <p class="text-muted ms-3 mt-2">
                {{ data_get($data[0], 'eval_topic_id.description') }}
            </p>
        @endif
    </div>

    @php
        // Group by the real question id key: "_id" (your dump shows this)
        $grouped = collect($data)
            ->groupBy(function ($row) {
                $qid = data_get($row, 'que_ans_id._id'); // <-- fix
                if ($qid) {
                    return $qid;
                }
                $qtext = (string) data_get($row, 'que_ans_id.question', '');
                return 'q_' . md5($qtext);
            })
            ->values();
    @endphp

    {{-- Render each question once --}}
    @foreach ($grouped as $qIndex => $items)
        @php
            $section = $items->first();
            $questionText = data_get($section, 'que_ans_id.question');
            $answers = data_get($section, 'que_ans_id.answers', []);
            $answerType = data_get($section, 'que_ans_id.answer_type');
            $reason = data_get($section, 'reason');
            $solving = data_get($section, 'solving');

            $showReason = filled($reason) && $reason !== 'null';
            $showSolving = filled($solving) && $solving !== 'null';
        @endphp

        <div class="section-container mb-5">
            {{-- Question text --}}
            @if ($questionText)
                <p class="fw-bold">{{ $qIndex + 1 }}. {{ $questionText }}</p>
            @endif

            {{-- By answer_type --}}
            @if (in_array($answerType, [1]))
                {{-- radio --}}
                <ul class="list-group mb-3">
                    @foreach ($answers as $answer)
                        @php
                            $isSelected = (bool) data_get($answer, 'answer');
                            $scoreVal = (int) data_get($answer, 'score', 0);
                            $isCorrect = $scoreVal > 0;
                            $liClass =
                                $isSelected && $isCorrect
                                    ? 'list-group-item-success'
                                    : ($isSelected && !$isCorrect
                                        ? 'list-group-item-danger'
                                        : (!$isSelected && $isCorrect
                                            ? 'list-group-item-warning'
                                            : ''));
                        @endphp
                        <li class="list-group-item {{ $liClass }}">
                            {{ data_get($answer, 'answer_name') }} ({{ $scoreVal }})
                        </li>
                    @endforeach
                </ul>
            @elseif (in_array($answerType, [2]))
                {{-- checkbox --}}
                <ul class="list-group mb-3">
                    @foreach ($answers as $answer)
                        @php
                            $isSelected = (bool) data_get($answer, 'answer');
                            $scoreVal = (int) data_get($answer, 'score', 0);
                        @endphp
                        <li class="list-group-item {{ $isSelected ? 'list-group-item-success' : '' }}">
                            {{ data_get($answer, 'answer_name') }} ({{ $scoreVal }})
                        </li>
                    @endforeach
                </ul>
            @elseif (in_array($answerType, [3]))
                {{-- select option --}}
                <select class="form-select" disabled>
                    @foreach ($answers as $answer)
                        <option {{ data_get($answer, 'answer') ? 'selected' : '' }}>
                            {{ data_get($answer, 'answer_name') }}
                        </option>
                    @endforeach
                </select>
            @elseif (in_array($answerType, [4]))
                {{-- input text --}}
                <input type="text" class="form-control" value="{{ data_get($answers, '0.answer') }}" readonly>
            @elseif (in_array($answerType, [5]))
                {{-- textarea --}}
                <textarea class="form-control" rows="2" readonly>{{ data_get($answers, '0.answer') }}</textarea>
            @elseif (in_array($answerType, [6]))
                {{-- file / image --}}
                @php $val = data_get($answers, '0.answer'); @endphp
                @if ($val)
                    <img src="" style="max-width:200px;">
                @else
                    <span class="text-muted">No image</span>
                @endif
            @elseif (in_array($answerType, [7]))
                {{-- number --}}
                <input type="number" class="form-control" value="{{ data_get($answers, '0.answer') }}" readonly>
            @elseif (in_array($answerType, [8]))
                {{-- date --}}
                <input type="date" class="form-control" value="{{ data_get($answers, '0.answer') }}" readonly>
            @endif

            {{-- Reason / Solving --}}
            @if ($showReason)
                <p><em>@lang('home.reason'):</em> {{ $reason }}</p>
            @endif
            @if ($showSolving)
                <p><em>@lang('home.solving'):</em> {{ $solving }}</p>
            @endif
        </div>
    @endforeach
@else
    <div class="alert alert-warning">@lang('home.No_response_data_available')</div>
@endif
