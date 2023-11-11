package lotto.domain

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun matchAll(winningNumbers: List<Int>): Lottos {
        val lottos = value.map { it.match(winningNumbers) }

        return Lottos(lottos)
    }

    fun totalReward(): Int {
        return value.sumOf { it.winning.reward }
    }
}
