package lotto.domain

enum class Rank(val numberOfMatch: Int, val money: Double) {
    FIRST(6, 200_000_000.0),
    SECOND(5, 1_500_000.0),
    THIRD(4, 50_000.0),
    FOURTH(3, 5_000.0);

    companion object {
        fun valueOf(matches: Int) = values().find { it.numberOfMatch == matches }
    }
}
