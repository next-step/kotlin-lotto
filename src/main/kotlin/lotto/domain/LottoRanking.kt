package lotto.domain

enum class LottoRanking(val correctCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun lottoRanking(correctCount: Int): LottoRanking {
            return values()
                .firstOrNull { ranking: LottoRanking -> ranking.correctCount == correctCount } ?: MISS
        }
    }
}
