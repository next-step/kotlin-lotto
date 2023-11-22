package lotto.domain

data class RankResult(private val value: Map<Rank, Int>) {
    fun totalPrize(): Long = value.map { it.key.prize * it.value }.sum()
}
