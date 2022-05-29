package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import java.math.BigDecimal

class OutputView {
    fun resultPurchaseLotto(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun resultLottoTickets(lottoTickets: List<LottoTicket>) {
        val result = buildString {
            lottoTickets.forEach {
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

    fun winningResult(lottoResults: List<LottoResult>, rateResult: BigDecimal) {
        val result = buildString {
            appendLine("\n당첨 통계")
            appendLine("---------")
            append(winningLottoResults(lottoResults))
            appendLine("총 수익률은 ${rateResult}입니다.")
        }
        print(result)
    }

    private fun winningLottoResults(lottoResults: List<LottoResult>): String = buildString {
        lottoResults.sortedBy { it.lottoPrize.rank }
            .forEach {
                if (it.lottoPrize == LottoPrize.SECOND) {
                    appendLine("${it.lottoPrize.matchCount}개 일치, 보너스 볼 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
                } else {
                    appendLine("${it.lottoPrize.matchCount}개 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
                }
            }
    }
}
