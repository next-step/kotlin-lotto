package lotto.view

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import lotto.domain.selling.ExchangeResult
import lotto.domain.selling.PaymentResult
import lotto.domain.selling.Rank

object ResultView {
    private const val PAYMENT_RESULT = "[수동 로또 목록]\n%s\n[자동 로또 목록]\n%s\n거스름돈: %d"

    private const val WINNING_STATISTICS_TITLE = "당첨 통계"
    private const val WINNING_EXCHANGE_RESULT = "%d장 - %d개 일치 (%d원)"
    private const val WINNING_EXCHANGE_RESULT_BONUS = "%d장 - %d개 일치, 보너스 볼 일치 (%d원)"
    private const val WINNING_EXCHANGE_RESULT_MISS = "%d장 - 꽝 ㅠㅠ"
    private const val WINNING_STATISTICS = "총 수익률은 %.2f 입니다."

    private const val INVALID_BONUS_NUMBER = "당첨 번호와 중복되지 않는 유효한 정수를 입력해주세요."
    private const val INVALID_MANUAL_COUNT = "처음 지불한 금액 이상의 로또를 발급받을 수 없습니다."
    private val ERR_INVALID_LOTTO_NUMBERS = "${LottoNumber.NUMBER_RANGE} 사이의 번호 " +
        "${LottoTicket.NUMBER_COUNT}개를 중복없이 입력해주세요."

    fun printInvalidLottoNumbers() {
        println(ERR_INVALID_LOTTO_NUMBERS)
    }

    fun printInvalidBonusNumber() {
        println(INVALID_BONUS_NUMBER)
    }

    fun printPaymentResult(result: PaymentResult) {
        println(
            PAYMENT_RESULT.format(
                result.findLottoTickets(LottoType.MANUAL).joinToString("\n"),
                result.findLottoTickets(LottoType.AUTO).joinToString("\n"),
                result.change
            )
        )
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
        Rank.SECOND -> WINNING_EXCHANGE_RESULT_BONUS
        else -> WINNING_EXCHANGE_RESULT
    }
}
