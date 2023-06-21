package lotto.domain

/**
 * ### 로또 당첨 결과에 따른 등수를 표현하는 Enum 클래스 입니다.
 *
 * 등수에 대한 상금 가지고 있습니다.
 * 당첨 번호 일치 결과에 따라 등수를 맵핑하는 역할을 합니다.
 */
enum class LottoRank(
    val matchCount: Int,
    val winningMoney: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(
            matchCount: Int,
            bonusMatched: Boolean = false,
        ): LottoRank {
            if (matchCount == 5 && bonusMatched) {
                return SECOND
            }
            return values()
                .filter { it != SECOND }
                .find { it.matchCount == matchCount } ?: MISS
        }
    }
}
