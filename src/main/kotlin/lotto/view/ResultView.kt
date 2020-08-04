package lotto.view

import lotto.domain.PaymentResult

object ResultView {
    private const val ERR_INVALID_COUNT = "양의 정수가 아닙니다. 다시 입력해주세요."
    private const val ERR_INVALID_WINNING_NUMBER = "유효한 당첨 번호가 아닙니다. 다시 입력해주세요."

    fun printPaymentResult(result: PaymentResult) {
        println(result)
    }

    fun printResult() {
    }

    fun printTryAgain() {
        println(ERR_INVALID_COUNT)
    }
}
