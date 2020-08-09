package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.selling.ExchangeResult
import lotto.domain.selling.PaymentResult
import java.math.BigDecimal

object ResultView {
    private const val PAYMENT_RESULT = "%s\n거스름돈: %d"
    private const val WINNING_STATISTICS_TITLE = "당첨 통계"
    private const val WINNING_EXCHANGE_RESULT = "%d개 일치 (%d원) - %d개"
    private const val WINNING_STATISTICS = "총 수익률은 %.2f 입니다."
    private val INVALID_LOTTO_NUMBERS = "${LottoNumber.NUMBER_RANGE} 사이의 번호 " +
        "${LottoTicket.NUMBER_COUNT}개를 중복없이 입력해주세요."

    fun printInvalidLottoNumbers() {
        println(INVALID_LOTTO_NUMBERS)
    }

    fun printPaymentResult(result: PaymentResult) {
        println(PAYMENT_RESULT.format(result.lottoTickets.joinToString("\n"), result.change))
    }

    fun printExchangeResult(exchangeResult: ExchangeResult, rateOfReturn: BigDecimal) {
        println("$WINNING_STATISTICS_TITLE\n---------")
        for (detail in exchangeResult.details) {
            println(WINNING_EXCHANGE_RESULT.format(detail.key.matchCount, detail.key.prizeMoney, detail.value))
        }
        println(WINNING_STATISTICS.format(rateOfReturn))
    }
}
