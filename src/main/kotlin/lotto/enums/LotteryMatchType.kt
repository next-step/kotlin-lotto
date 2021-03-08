package lotto.enums

enum class LotteryMatchType(
    val matchCount: Int?,
    val winningPrice: Int,
    val description: String
) {
    NonProfit(null, 0, "2개 이하"),
    Three(3, 5_000, "3개 일치"),
    Four(4, 50_000, "4개 일치"),
    Five(5, 1_500_000, "5개 일치"),
    Six(6, 2_000_000_000, "6개 일치");

    companion object {
        fun findByMatchCount(matchCount: Int): LotteryMatchType {
            return values().find { it.matchCount == matchCount } ?: NonProfit
        }
    }
}
