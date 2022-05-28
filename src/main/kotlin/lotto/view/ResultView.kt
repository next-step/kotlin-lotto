package lotto.view

import lotto.domain.LottoRank
import lotto.dto.LottoTicketsResponse
import lotto.dto.WinningLottoResponse
import java.math.BigDecimal

object ResultView {
    private const val LOTTO_NUMBER_DELIMITER = ", "
    private const val REWARD = "\n당첨 통계\n---------"
    private const val PROFIT_RATE_BENEFIT = "(기준이 1을 넘어서 이득임)"
    private const val PROFIT_RATE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"

    fun printLottoTickets(lottoTickets: LottoTicketsResponse) {
        println("수동으로 ${lottoTickets.manualCount}장, 자동으로 ${lottoTickets.autoCount}장을 구매했습니다.")

        lottoTickets.lottoTickets
            .forEach {
                println("[${it.lottoNumbers.joinToString(LOTTO_NUMBER_DELIMITER)}]")
            }

        println()
    }

    fun printRank(winningLotto: WinningLottoResponse) {
        println(REWARD)
        printCountByRank(winningLotto.countByRank)
        printProfitRate(winningLotto.profitRate)
    }

    private fun printCountByRank(countByRank: Map<LottoRank, Int>) {
        countByRank.forEach { printRank(it.key, it.value) }
    }

    private fun printRank(lottoRank: LottoRank, count: Int) {
        val matchCount = lottoRank.matchCounts.first()
        val winningAmount = lottoRank.winningAmount.amount

        if (lottoRank == LottoRank.SECOND) {
            println("${matchCount}개 일치, 보너스 볼 일치(${winningAmount}원)- ${count}개")
        } else {
            println("${matchCount}개 일치 (${winningAmount}원)- ${count}개")
        }
    }

    private fun printProfitRate(profitRate: BigDecimal) {
        print("총 수익율은 $profitRate 입니다.")
        if (profitRate >= BigDecimal.ONE) {
            print(PROFIT_RATE_BENEFIT)
        } else {
            print(PROFIT_RATE_LOSS)
        }
    }
}
