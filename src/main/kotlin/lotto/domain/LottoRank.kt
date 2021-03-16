package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val price: Int,
    val infoString: String = "${matchCount}개 일치 (${price}원)"
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OUT(0, 0);

    companion object {
        fun findRank(matchCount: Int, isBonusNumber: Boolean = false): LottoRank {
            if (matchCount == BONUS.matchCount && isBonusNumber)
                return BONUS
            return values()
                .firstOrNull { it.matchCount == matchCount } ?: OUT
        }
    }
}
