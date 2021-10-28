package lotto.model

enum class LottoRank(
    val winnings: Int
) {
    First(2_000_000_000),
    Second(1_500_000),
    Third(50_000),
    Fourth(10_000),
    Fifth(5_000)
}
