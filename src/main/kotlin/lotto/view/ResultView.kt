package lotto.view

import lotto.domain.Lottery
import lotto.domain.LottoStatResult
import lotto.domain.PurchasedLottery
import lotto.domain.Rank

object ResultView {
    private fun showLottery(lottery: Lottery) {
        println(
            lottery.lottoList.joinToString("\n") {
               "[${it.numbers.map { lottoNumber -> lottoNumber.number }.joinToString(", ")}]"
            } + "\n"
        )
    }

    private fun showRank(rank: Rank, rankCount: Int) {
        println(
            TextResource.resultByRank(
                countOfMatch = rank.countOfMatch,
                isMatchBonus = rank.isMatchBonus,
                winningMoney = rank.winningMoney,
                rankCount = rankCount,
            )
        )
    }

    fun showPurchasedLottery(purchasedLottery: PurchasedLottery) {
        println(
            TextResource.countOfPurchasedLottery(
                manualCount = purchasedLottery.getManualCount(),
                autoCount = purchasedLottery.getAutoCount()
            )
        )

        showLottery(purchasedLottery.getLottery())
    }

    fun showLottoStatResult(lottoStatResult: LottoStatResult) {
        val returnRate = lottoStatResult.getReturnRate()

        println("\n${TextResource.LOTTO_RESULT}")
        Rank.values().filter { it.countOfMatch > 0 }.forEach {
            showRank(it, lottoStatResult.getCount(it))
        }
        println(TextResource.total_return_rate(returnRate))
    }
}
