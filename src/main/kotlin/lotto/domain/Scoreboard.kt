package lotto.domain

@JvmInline
value class Scoreboard private constructor(private val value: Map<Prize, Int>) {
    fun toMap() = value.toMap()

    fun totalPrize() = value.map { it.key.money * it.value }.sum()

    private fun List<Money>.sum(): Money = reduce { acc, money -> acc + money }

    companion object {
        fun of(lottos: Lottos, winningLotto: Lotto) = Scoreboard(
            lottos.matchCount(winningLotto)
                .map { Prize.of(it) }
                .groupingBy { it }
                .eachCount()
        )
    }
}
