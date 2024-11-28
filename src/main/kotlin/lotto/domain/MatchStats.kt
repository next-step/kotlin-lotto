package lotto.domain

data class MatchStats(
    val count: Int,
    val isBonusMatched: Boolean = false,
) {
    fun countEquals(count: Int): Boolean = this.count == count

    fun countIsIn(
        start: Int,
        endInclusive: Int,
    ): Boolean = count in start..endInclusive
}
