package lotto.enums

enum class LotteryMatchType(
    val matchCount: Int?,
    val winningPrice: Int
) {
    NonProfit(null, 0),
    Three(3, 5_000),
    Four(4, 50_000),
    Five(5, 1_500_000),
    FiveWithBonus(5, 30_000_000),
    Six(6, 2_000_000_000);

    companion object {
        fun findByMatchCount(matchCount: Int, hasBonusNumber: Boolean): LotteryMatchType {
            if (matchCount == FiveWithBonus.matchCount && hasBonusNumber) {
                return FiveWithBonus
            }
            return values().filter { it != FiveWithBonus }.find { it.matchCount == matchCount } ?: NonProfit
        }
    }
}
