package lotto.domain

class LottoResult(
    private val _result: MutableMap<LottoWinningCount, Int> = mutableMapOf()
) {
    val result: Map<LottoWinningCount, Int>
        get() = _result.toMap()

    init {
        _result[LottoWinningCount.THREE] = 0
        _result[LottoWinningCount.FOUR] = 0
        _result[LottoWinningCount.FIVE] = 0
        _result[LottoWinningCount.SIX] = 0
    }

    fun add(matchCount: Int) {
        if (LottoWinningCount.isNotWinningCount(matchCount)) {
            return
        }
        val winningCount = LottoWinningCount.of(matchCount)
        val originalResult = _result[winningCount] ?: return
        _result[winningCount] = originalResult.plus(1)
    }

    fun calculateEarningRate(buyingPrice: LottoBuyingPrice): Double {
        val earningMoney = result.map { (winningCount, _) ->
            val winningMoney = winningCount.winningMoney
            val matchCount = result[winningCount] ?: 0
            winningMoney.times(matchCount).toLong()
        }.sum()
        return earningMoney.toDouble().div(buyingPrice.value)
    }

    enum class LottoWinningCount(
        val count: Int,
        val winningMoney: Int
    ) {
        THREE(3, 5_000),
        FOUR(4, 50_000),
        FIVE(5, 1_500_000),
        SIX(6, 2_000_000_000)
        ;

        companion object {
            fun of(matchCount: Int): LottoWinningCount {
                return values().first { it.count == matchCount }
            }

            fun isNotWinningCount(matchCount: Int): Boolean {
                return matchCount < THREE.count || matchCount > SIX.count
            }
        }
    }
}
