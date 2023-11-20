package lotto

data class Lotto(
    val numbers: List<Int>,
) {
    var rank: Rank = Rank.MISS
        private set

    fun setRank(rank: Rank?) {
        this.rank = rank ?: Rank.MISS
    }
}
