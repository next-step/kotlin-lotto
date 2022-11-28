package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Reward

object OutputView {


    fun printLottos(lottos: Lottos) {
        printLottoNumber(lottos.lottos.size)
        lottos.lottos.forEach {
            print("[")
            printLotto(it)
            print("]\n")
        }
    }

    private fun printLottoNumber(lottoNumber: Int) = println("$lottoNumber 개를 구매하였습니다")

    private fun printLotto(lotto: Lotto) {
        print(lotto.lotto.joinToString {
            "${it.lottoBall}"
        })
    }

    fun printRewards(rewards: List<Reward>, money: Int) {
        println("당첨 통계\n ---------")
        rewards.groupBy { it }
            .filter { it.key != Reward.NO_RANK }
            .forEach { println("${it.key.matchNumber}개 일치 (${it.key.reward}) - ${it.value.size}개") }

        println("총 수익률은 ${calculateProfit(rewards, money)}입니다.")
    }

    private fun calculateProfit(rewards: List<Reward>, money: Int): Float {
        val reward = rewards.sumOf { it.reward }
        return (reward - money) / money.toFloat()
    }

}
