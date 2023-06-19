package lotto

enum class WinnerPrize(val money: Int) {

    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    LAST(5_000);

    companion object {
        fun getPrize(sameCount: Int): WinnerPrize = when (sameCount) {
            3 -> LAST
            4 -> THIRD
            5 -> SECOND
            else -> FIRST
        }
    }
}
