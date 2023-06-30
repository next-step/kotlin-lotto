package lotto.enums

enum class LottoReturn(
    val matchCount: Int,
    val returnPrice: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun from(matchCount: Int, bonusMatch: Boolean): LottoReturn {
            if (bonusMatch && matchCount == SECOND.matchCount) {
                return SECOND
            }
            if (!bonusMatch && matchCount == THIRD.matchCount) {
                return THIRD
            }
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
