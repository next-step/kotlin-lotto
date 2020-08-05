package lotto.view

import lotto.domain.selling.PaymentResult

object ResultView {
    private const val ERR_INVALID_COUNT = "양의 정수가 아닙니다. 다시 입력해주세요."
    private const val ERR_INVALID_WINNING_NUMBER = "유효한 당첨 번호가 아닙니다. 다시 입력해주세요."
    private const val WINNING_STATISTICS_TITLE = "당첨 통계"
    private const val WINNING_STATISTICS = "3개 일치 (5000원)- %d개\n" +
        "4개 일치 (50000원)- %d개\n" +
        "5개 일치 (1500000원)- %d개\n" +
        "6개 일치 (2000000000원)- %d개\n" +
        "총 수익률은 %f 입니다."

    fun printPaymentResult(result: PaymentResult) {
        println(result)
    }

    fun printResult() {
        println("$WINNING_STATISTICS\n---------")
    }

    fun printTryAgain() {
        println(ERR_INVALID_COUNT)
    }
}
