package lotto.domain

class Lottos(val lottos: List<Lotto>) {

    fun matchNumbers(winningLotto: Lotto): List<Reward> {
        return lottos.map {
            val matchNumber = it.matchNumberWith(winningLotto)
            Reward.getReward(matchNumber)
        }
    }
}
