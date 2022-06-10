package lotto.domain

enum class Rank(val matched: Int, val prize: Double) {
    FIRST(6, 2_000_000_000.0),
    SECOND(5, 1_500_000.0),
    THIRD(4, 50_000.0),
    FOURTH(3, 5_000.0),
    LOSE(0, 0.0);

    companion object {
        fun of(matched: Int): Rank {
            return values().firstOrNull { it.matched == matched } ?: LOSE
        }
    }
}
