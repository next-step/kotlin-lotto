package lotto.domain

enum class LottoWinnerRank(val matchCount: Int, val bonusCheck: Boolean, val winningMoney: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0),
    ;

    companion object {
        fun getRankByMatches(
            matchCount: Int,
            bonusCheck: Boolean,
        ): LottoWinnerRank {
            if (matchCount >= 0 && matchCount < FIFTH.matchCount) {
                return MISS
            }

            if (matchCount == SECOND.matchCount && bonusCheck == SECOND.bonusCheck) {
                return SECOND
            }

            if (matchCount == THIRD.matchCount && bonusCheck == THIRD.bonusCheck) {
                return THIRD
            }

            val findLottoWinnerRank =
                LottoWinnerRank.entries.find { it.matchCount == matchCount }

            requireNotNull(findLottoWinnerRank) { INVALID_MATCH_COUNT_MESSAGE }
            return findLottoWinnerRank
        }

        private const val INVALID_MATCH_COUNT_MESSAGE: String = "로또 번호 매칭 카운트에 매칭되는 범위를 벗어났습니다"
    }
}
