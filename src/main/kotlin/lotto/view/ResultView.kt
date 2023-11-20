package lotto.view

import lotto.domain.Lottery
import lotto.domain.LottoStatResult
import lotto.domain.PurchasedLottery
import lotto.domain.Rank

object ResultView {
    private fun showLottery(lottery: Lottery) {
        println(
            lottery.lottoList.joinToString("\n") {
                it.numbers.toString()
            } + "\n"
        )
    }

    private fun showRank(rank: Rank, rankCount: Int) {
        println(
            "${rank.countOfMatch}개 일치".let { text ->
                if (rank.isMatchBonus) {
                    "$text, 보너스 볼 일치"
                } else {
                    "$text "
                }
            }.let { text ->
                "$text(${rank.winningMoney}원)- ${rankCount}개"
            }
        )
    }

    fun showPurchasedLottery(purchasedLottery: PurchasedLottery) {
        println("수동으로 ${purchasedLottery.getManualCount()}장, 자동으로 ${purchasedLottery.getAutoCount()}개를 구매했습니다.")

        showLottery(purchasedLottery.getLottery())
    }

    fun showLottoStatResult(lottoStatResult: LottoStatResult) {
        val returnRate = lottoStatResult.getReturnRate()

        println("\n당첨 통계\n---------")
        Rank.values().filter { it.countOfMatch > 0 }.forEach {
            showRank(it, lottoStatResult.getCount(it))
        }
        println("총 수익률은 ${returnRate}입니다.${if (returnRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }
}
