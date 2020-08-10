package lotto

enum class Rank(val count: Int, val prize: Int) {
    NONE(0, 0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        fun of(matchCount: Int): Rank {
            return Rank.values().filter { it.count == matchCount }[0]
        }
    }
}
