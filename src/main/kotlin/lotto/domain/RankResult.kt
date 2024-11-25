package lotto.domain

data class RankResult(
    val totalCount: Int,
    val prize: Prize,
) {
    fun getTotalPrizeMoney(): Int {
        return this.prize.prizeAmount * totalCount
    }
}
