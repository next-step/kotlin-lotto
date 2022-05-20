package lotto

enum class LottoRanking(
    val matchCount: Int,
    val winningAmount: Long
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTTING(2, 0);

    companion object {
        fun of(matchCount: Int): LottoRanking {
            require(matchCountRange(matchCount)) {
                "당첨 결과는 0~6 까지 허용합니다 (입력:$matchCount)"
            }

            return LottoRanking.values()
                .find { it.matchCount == matchCount }
                ?: NOTTING
        }

        private fun matchCountRange(matchCount: Int) = matchCount in 0..6
    }
}
