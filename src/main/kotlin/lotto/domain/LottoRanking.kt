package lotto.domain

enum class LottoRanking(val correctCount: Int, val price: Int) {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    companion object {
        fun lottoRanking(correctCount: Int): LottoRanking {
            return values()
                .filter { lotto: LottoRanking -> lotto != MISS }
                .firstOrNull { ranking: LottoRanking -> ranking.correctCount == correctCount } ?: MISS
        }
    }
}
