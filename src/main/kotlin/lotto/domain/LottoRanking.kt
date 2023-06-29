package lotto.domain

enum class LottoRanking(val correctCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun lottoRanking(correctCount: Int, matchedBonusBall: Boolean): LottoRanking {
            val lottoRanking = values()
                .reversed()
                .firstOrNull { ranking: LottoRanking -> ranking.correctCount == correctCount } ?: MISS

            if (lottoRanking == THIRD && matchedBonusBall) {
                return LottoRanking.SECOND
            }

            return lottoRanking
        }
    }
}
