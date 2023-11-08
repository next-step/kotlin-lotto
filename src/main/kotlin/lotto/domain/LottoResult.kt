package lotto.domain

class LottoResult(
    private val _result: MutableMap<Rank, Int> = mutableMapOf()
) {
    val result: Map<Rank, Int>
        get() = _result.toMap()

    init {
        _result[Rank.THREE] = 0
        _result[Rank.FOUR] = 0
        _result[Rank.FIVE] = 0
        _result[Rank.SIX] = 0
    }

    fun add(matchCount: Int) {
        if (Rank.isNotWinningRank(matchCount)) {
            return
        }
        val rank = Rank.of(matchCount)
        val originalCount = _result[rank] ?: return
        _result[rank] = originalCount.plus(1)
    }

    fun calculateEarningRate(buyingPrice: LottoBuyingPrice): Double {
        val earningMoney = result.map { (rank, _) ->
            val winningMoney = rank.winningMoney
            val matchCount = result[rank] ?: 0
            winningMoney.times(matchCount).toLong()
        }.sum()
        return earningMoney.toDouble().div(buyingPrice.value)
    }

    enum class Rank(
        val countOfMatch: Int,
        val winningMoney: Int
    ) {
        THREE(3, 5_000),
        FOUR(4, 50_000),
        FIVE(5, 1_500_000),
        SIX(6, 2_000_000_000)
        ;

        companion object {
            fun of(matchCount: Int): Rank {
                return values().first { it.countOfMatch == matchCount }
            }

            fun isNotWinningRank(matchCount: Int): Boolean {
                return matchCount < THREE.countOfMatch || matchCount > SIX.countOfMatch
            }
        }
    }
}
