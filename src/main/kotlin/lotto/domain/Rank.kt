package lotto.domain

enum class Rank(val numberOfMatch: Int, val money: Double) {
    FIRST(6, 2000000000.0),
    SECOND(5, 1500000.0),
    THIRD(4, 50000.0),
    FOURTH(3, 5000.0);

    companion object {
        fun fromOrNull(matches: Int) = values().firstOrNull() { it.numberOfMatch == matches }
    }
}
