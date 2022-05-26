package lotto.domain.model

enum class LottoRank(
    val numberOfMatches: Int,
    val winnings: Int
) {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        val NUMBER_OF_MATCHES_RANGE = FOURTH.numberOfMatches..FIRST.numberOfMatches
    }
}
