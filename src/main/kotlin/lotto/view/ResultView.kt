package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.selling.ExchangeResult
import lotto.domain.selling.PaymentResult
import lotto.domain.selling.Rank

object ResultView {
    private const val PAYMENT_RESULT = "%s\n거스름돈: %d"

    private const val WINNING_STATISTICS_TITLE = "당첨 통계"
    private const val WINNING_EXCHANGE_RESULT = "%d장 - %d개 일치 (%d원)"
    private const val WINNING_EXCHANGE_RESULT_BONUS = "%d장 - %d개 일치, 보너스 볼 일치 (%d원)"
    private const val WINNING_EXCHANGE_RESULT_MISS = "%d장 - 꽝 ㅠㅠ"
    private const val WINNING_STATISTICS = "총 수익률은 %.2f 입니다."

    private const val INVALID_BONUS_NUMBER = "당첨 번호와 중복되지 않는 유효한 정수를 입력해주세요."
    private val INVALID_LOTTO_NUMBERS = "${LottoNumber.NUMBER_RANGE} 사이의 번호 " +
        "${LottoTicket.NUMBER_COUNT}개를 중복없이 입력해주세요."

    fun printInvalidLottoNumbers() {
        println(INVALID_LOTTO_NUMBERS)
    }

    fun printInvalidBonusNumber() {
        println(INVALID_BONUS_NUMBER)
    }

    fun printPaymentResult(result: PaymentResult) {
        println(PAYMENT_RESULT.format(result.lottoTickets.joinToString("\n"), result.change))
    }

    fun printExchangeResult(exchangeResult: ExchangeResult) {
        println("$WINNING_STATISTICS_TITLE\n---------")
        for (detail in exchangeResult.details) {
            val rank = detail.key
            println(getResultFormat(rank).format(detail.value, rank.matchCount, rank.prizeMoney))
        }
        println(WINNING_STATISTICS.format(exchangeResult.rateOfReturn))
    }

    private fun getResultFormat(rank: Rank) = when (rank) {
        Rank.MISS -> WINNING_EXCHANGE_RESULT_MISS
        Rank.SECOND_HAS_BONUS -> WINNING_EXCHANGE_RESULT_BONUS
        else -> WINNING_EXCHANGE_RESULT
    }
}
