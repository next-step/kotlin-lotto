enum class Winning(val price: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun matchWinning(match: Int): Winning {
            return values().firstOrNull { it.match == match } ?: NONE
        }
    }
}
