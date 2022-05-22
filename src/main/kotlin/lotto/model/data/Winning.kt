package lotto.model.data

enum class Winning(val matchCount: Int, val winMoney: Int, val isMustBonusNumberMatch: Boolean = false) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, isMustBonusNumberMatch = true),
    FIRST(6, 2_000_000_000),
    LOST_GAME(0, 0)
}
