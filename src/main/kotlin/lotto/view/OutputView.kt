package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import java.math.BigDecimal

object OutputView {
    fun resultPurchaseLotto(lottoCount: Int, lottoTickets: LottoTickets) {
        println("${lottoCount}개를 구매했습니다.")
        resultLottoTickets(lottoTickets = lottoTickets)
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
        lottoResults.get().sortedBy { it.lottoPrize.rank }
            .forEach {
                if (it.lottoPrize == LottoPrize.SECOND) {
                    appendLine("${it.lottoPrize.matchCount}개 일치, 보너스 볼 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
                } else {
                    appendLine("${it.lottoPrize.matchCount}개 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
                }
            }
    }
}
