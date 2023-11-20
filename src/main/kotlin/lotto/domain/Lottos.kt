package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun matchAll(winningLotto: WinningLotto): Lottos {
        val lottos = value.map { it.match(winningLotto) }

        return Lottos(lottos)
    }

    fun totalReward(): Int {
        return value.sumOf { it.winning.reward }
    }
}
