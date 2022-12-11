package lotto.model

enum class Rank(val match: Int, val reward: Int) {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_LUCK(0, 0);

    companion object {
        private val rank =
            mapOf(6 to FIRST, 5 to THIRD, 4 to FOURTH, 3 to FIFTH, 2 to NO_LUCK, 1 to NO_LUCK, 0 to NO_LUCK)

        fun of(number: Int): Rank {
            return rank[number]!!
        }
    }
}
