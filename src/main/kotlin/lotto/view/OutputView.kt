package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import lotto.domain.LottoTicket
import lotto.domain.LottoTicketCount
import lotto.domain.LottoTickets
import java.math.BigDecimal

object OutputView {
    fun resultPurchaseLotto(lottoTicketCount: LottoTicketCount, lottoTickets: LottoTickets) {
        println("수동으로 ${lottoTicketCount.manualTicketCount}장, 자동으로 ${lottoTicketCount.autoTicketCount}장을 구매했습니다.")
        resultLottoTickets(lottoTickets)
    }

    private fun resultLottoTickets(lottoTickets: LottoTickets) {
        val result = buildString {
            lottoTickets.get().forEach {
                appendLine(lottoTicketToString(it))
            }
        }
        print(result)
    }

    private fun lottoTicketToString(lottoTicket: LottoTicket): String = buildString {
        append("[")
        lottoTicket.toSortedList().forEachIndexed { index, lottoNumber ->
            append(lottoNumber)
            if (index != LottoTicket.LOTTO_NUMBER_COUNT - 1) {
                append(", ")
            }
        }
        append("]")
    }

    fun winningResult(lottoResults: LottoResults, rateResult: BigDecimal) {
        val result = buildString {
            appendLine("\n당첨 통계")
            appendLine("---------")
            append(winningLottoResults(lottoResults))
            appendLine("총 수익률은 ${rateResult}입니다.")
        }
        print(result)
    }

    private fun winningLottoResults(lottoResults: LottoResults): String = buildString {
        LottoPrize.values().sortedByDescending { it.rank }.forEach { lottoPrize ->
            val lottoCount = lottoResults.get()
                .firstOrNull { it.lottoPrize == lottoPrize }
                ?.matchedLottoCount ?: 0
            if (lottoPrize == LottoPrize.SECOND) {
                appendLine("${lottoPrize.matchCount}개 일치, 보너스 볼 일치 (${lottoPrize.prizeMoney}원) - ${lottoCount}개")
            } else {
                appendLine("${lottoPrize.matchCount}개 일치 (${lottoPrize.prizeMoney}원) - ${lottoCount}개")
            }
        }
    }
}
