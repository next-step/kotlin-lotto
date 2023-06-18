package lotto.domain

enum class Rank(val rank: Int, val count: Int, val reward: Int) {
    FIRST(1, 6, 2000000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    companion object {
        fun getValue(count: Int): Rank? {
            return when (count) {
                6 -> FIRST
                5 -> THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> null
            }
        }
    }
}
