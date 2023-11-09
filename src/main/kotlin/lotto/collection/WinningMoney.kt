package lotto.collection

enum class WinningMoney(
    val prize: Int
) {
    ZeroMatch(0),
    OneMatch(0),
    TwoMatch(0),
    ThreeMatch(5000),
    FourMatch(50000),
    FiveMatch(1500000),
    SixMatch(2000000000);

    companion object {
        fun getPrizePerMatch(matched: Int) = when (matched) {
            0 -> ZeroMatch
            1 -> OneMatch
            2 -> TwoMatch
            3 -> ThreeMatch
            4 -> FourMatch
            5 -> FiveMatch
            6 -> SixMatch
            else -> ZeroMatch
        }.prize
    }
}
