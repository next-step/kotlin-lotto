package lotto.model
enum class LottoRank(
    val price: Long,
    val matches: Int
) {

    FIRST(
        price = 2_000_000_000,
        matches = 6
    ),

    SECOND(
        price = 1_500_000,
        matches = 5
    ),

    THIRD(
        price = 50_000,
        matches = 4
    ),

    FOURTH(
        price = 5_000,
        matches = 3
    );

    companion object {
        fun find(matchCount: Int): LottoRank? = values().find { it.matches == matchCount }
    }
}
