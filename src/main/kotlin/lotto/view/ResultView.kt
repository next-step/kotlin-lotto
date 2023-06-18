package lotto.view

import lotto.domain.Lottery
import lotto.domain.LotteryGroup
import lotto.domain.LottoMachine
import lotto.domain.MyLotteryGroup
import lotto.domain.Rank
import lotto.domain.Ranking

object ResultView {

    fun showBuyResult(lotteryGroup: MyLotteryGroup) {
        println("수동으로 ${lotteryGroup.lotteryHandCount.count}장, 자동으로 ${lotteryGroup.lotteryMachineCount.count}를 구매했습니다.")
        showLotteries(lotteryGroup)
        println()
    }

    private fun showLotteries(lotteryGroup: LotteryGroup) {
        lotteryGroup.lotteries.forEach {
            showBuyLotto(it)
        }
    }

    private fun showBuyLotto(lotto: Lottery) {
        println(lotto.lottery.map { it.number })
    }

    fun showGameResult(ranking: Ranking) {
        println("당첨 통계")
        println("---------")
        ranking.rankingResult.toSortedMap { o1, o2 ->
            o2.compareTo(o1)
        }.forEach {
            printGradeResult(it)
        }
        val rateOfReturn = LottoMachine.rateOfReturn.rate
        val result = if (rateOfReturn > 1) "이익" else "손해"
        println("총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }

    private fun printGradeResult(result: Map.Entry<Rank, Int>) {
        if (result.key == Rank.MISSING) {
            return
        }
        if (result.key == Rank.SECOND) {
            println("${result.key.countOfMatch}개 일치, 보너스 볼 일치 (${result.key.winningMoney}원) - ${result.value}개")
        } else {
            println("${result.key.countOfMatch}개 일치 (${result.key.winningMoney}원) - ${result.value}개")
        }
    }
}
