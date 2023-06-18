package lotto.view

import lotto.domain.Lottery
import lotto.domain.LottoMachine
import lotto.domain.LotteryGroup
import lotto.domain.Rank
import lotto.domain.Ranking

object ResultView {

    fun showBuyResult(lotteryByHade: LotteryGroup, lotteryByMachine: LotteryGroup) {
        println("수동으로 ${lotteryByHade.lotteries.size}장, 자동으로 ${lotteryByMachine.lotteries.size}를 구매했습니다.")
        showLotteries(lotteryByHade)
        showLotteries(lotteryByMachine)
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
        ranking.rankingResult.toSortedMap().forEach {
            printGradeResult(it)
        }
        val result = if (LottoMachine.rateOfReturn > 1) "이익" else "손해"
        println("총 수익률은 ${String.format("%.2f", LottoMachine.rateOfReturn)}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }

    private fun printGradeResult(result: Map.Entry<Rank, Int>) {
        if (result.key == Rank.MISSING) {
            return
        }
        if (result.key == Rank.SECOND) {
            println("${result.key.countOfMatch}개 일치, 보너스 볼 일치 (${result.key.winningMoney}원) - ${result.value}개")
        }
        println("${result.key.countOfMatch}개 일치 (${result.key.winningMoney}원) - ${result.value}개")
    }
}
