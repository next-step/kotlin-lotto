package lotto

data class Lotto(
    val numbers: Set<Int>,
) {
    var rank: Rank = Rank.MISS
        private set

    fun setRank(rank: Rank?) {
        this.rank = rank ?: Rank.MISS
    }

    companion object {

        fun of(): Lotto {
            val numbers = (LOTTO_MIN_VALUE..LOTTO_MAX_VALUE).toList().shuffled().take(LOTTO_COUNT).sorted().toSet()
            return Lotto(numbers)
        }

        private const val LOTTO_MIN_VALUE = 1
        private const val LOTTO_MAX_VALUE = 45
        private const val LOTTO_COUNT = 6
    }
}
