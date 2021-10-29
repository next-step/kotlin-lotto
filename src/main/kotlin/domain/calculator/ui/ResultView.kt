package domain.calculator.ui

import domain.calculator.ui.ViewConstants.OUTPUT_RESULT_MESSAGE
import global.strategy.OutputStrategy

class ResultView(private val outputStrategy: OutputStrategy) {
    fun output(element: String) = outputStrategy.output(OUTPUT_RESULT_MESSAGE + element)
}
// String '덧셈 연산' 과 'format' 속도 비교시 덧셈이 빨라서 덧셈으로 이용했습니다.
