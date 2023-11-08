package lotto.domain

class LottoResult(
    private val _result: MutableMap<LottoMatchCount, Int> = mutableMapOf()
) {
    val result: Map<LottoMatchCount, Int>
        get() = _result.toMap()

    init {
        _result[LottoMatchCount.THREE] = 0
        _result[LottoMatchCount.FOUR] = 0
        _result[LottoMatchCount.FIVE] = 0
        _result[LottoMatchCount.SIX] = 0
    }

    fun add(matchCount: Int) {
        if (LottoMatchCount.isNotWinningCount(matchCount)) {
            return
        }
        val lottoMatchCount = LottoMatchCount.of(matchCount)
        val originalResult = _result[lottoMatchCount] ?: return
        _result[lottoMatchCount] = originalResult.plus(1)
    }

    enum class LottoMatchCount(private val count: Int) {
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6)
        ;

        companion object {
            fun of(matchCount: Int): LottoMatchCount {
                return values().first { it.count == matchCount }
            }

            fun isNotWinningCount(matchCount: Int): Boolean {
                return matchCount < THREE.count || matchCount > SIX.count
            }
        }
    }
}
