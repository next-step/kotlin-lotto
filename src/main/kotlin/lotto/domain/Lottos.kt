package lotto.domain

class Lottos(val lottos: List<Lotto>) {

    fun matchNumbers(lotto: Lotto, bonusBall: LottoBall): Rewards {
        return Rewards(
            lottos.map {
                val matchNumber = it.matchNumberWith(lotto)
                Reward.getReward(matchNumber, it.containsBall(bonusBall))
            }
        )
    }

    operator fun plus(lottos: Lottos) = Lottos(this.lottos + lottos.lottos)
    fun size(): Int = this.lottos.size
}
