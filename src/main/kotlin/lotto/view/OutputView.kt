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
        print(
            lotto.lotto.joinToString {
                "${it.lottoBall}"
            }
        )
    }

    fun printRewards(rewards: List<Reward>, profit: Float) {
        println("당첨 통계\n ---------")
        val totalResult = addEmptyReward(rewards.groupBy { it })
        totalResult.toList()
            .sortedBy { (key, _) -> key.reward }
            .toMap()
            .filter { it.key != Reward.NO_RANK }
            .forEach { printRank(it) }
        println("총 수익률은 $profit 입니다.")
    }

    private fun addEmptyReward(existReward: Map<Reward, List<Reward>>): Map<Reward, List<Reward>> {
        val existReward = existReward.toMutableMap()
        Reward.values()
            .subtract(existReward.keys)
            .forEach { existReward[it] = listOf() }
        return existReward.toMap()
    }

    private fun printRank(rank: Map.Entry<Reward, List<Reward>>) {
        if (rank.key == Reward.SECOND_RANK) {
            println("${rank.key.matchNumber - 1}개 일치,보너스 볼 일치(${rank.key.reward}) - ${rank.value.size}개")
            return
        }
        println("${rank.key.matchNumber}개 일치 (${rank.key.reward}) - ${rank.value.size}개")
    }
}
