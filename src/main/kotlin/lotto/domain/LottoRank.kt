package lotto.domain

enum class LottoRank(val collectCount: Int, val price: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    OUT(0, 0);

    companion object {
        fun findRank(collectCount: Int): LottoRank {
            return values()
                .firstOrNull { it.collectCount == collectCount } ?: OUT
        }
    }
}
