package lotto.view

import lotto.domain.selling.ExchangeResult
import lotto.domain.selling.PaymentResult

object ResultView {
    private const val WINNING_STATISTICS_TITLE = "당첨 통계"
    private const val WINNING_EXCHANGE_RESULT = "%d개 일치 (%d원) - %d개"
    private const val WINNING_STATISTICS = "총 수익률은 %.2f 입니다."

    fun printPaymentResult(result: PaymentResult) {
        println(result)
    }

    fun printExchangeResult(exchangeResult: ExchangeResult) {
        println("$WINNING_STATISTICS_TITLE\n---------")
        for (detail in exchangeResult.details) {
            println(WINNING_EXCHANGE_RESULT.format(detail.key, ExchangeResult.findPrizeMoney(detail.key), detail.value))
        }
        println(WINNING_STATISTICS.format(exchangeResult.calculateRateOfReturn()))
    }
}
