package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Rank

class ResultView {
    companion object {
        fun printLottoNumbers(lottoTickets: LottoTickets) {
            val manualLottoCount = lottoTickets.manualTickets.size
            val autoLottoCount = lottoTickets.autoTickets.size

            println("수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}장을 구매했습니다.")
            lottoTickets.tickets.forEach {
                println("[${it.numbers.joinToString(", ")}]")
            }
        }

        fun printResult(result: LottoResult.Result) {
            println("당첨 통계")
            println("---------")
            printRankInfo(result)
            printProfitRate(result)
        }

        private fun printProfitRate(result: LottoResult.Result) {
            println(
                "총 수익률은 ${result.profitRate}입니다. " +
                    "(기준이 1이기 때문에 결과적으로 ${if (result.isProfit) "이익" else "손해"}입니다.)",
            )
        }

        private fun printRankInfo(result: LottoResult.Result) {
            result.rankInfo.forEach { (rank, count) ->
                if (rank == Rank.NONE) {
                    return@forEach
                }

                if (rank == Rank.SECOND) {
                    println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.winningMoney}원)- ${count}개")
                    return@forEach
                }

                println("${rank.matchCount}개 일치 (${rank.winningMoney}원)- ${count}개")
            }
        }
    }
}
