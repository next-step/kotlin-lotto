package lotto.enums

enum class LottoReturn(
    val matchCount: Int,
    val returnPrice: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun from(matchCount: Int): LottoReturn {
            require(matchCount in 0..6)
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
