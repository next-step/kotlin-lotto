package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val size = values.size
    val cost: Money = Money(size * Lotto.PRICE)

    fun calculateResults(
        winningLotto: WinningLotto,
    ): LottosResult {
        val results = LottoRank.createMapWithLottoRankAndZero()
        values.forEach { lotto ->
            val lottoRank = lotto.calculateResult(winningLotto) ?: return@forEach
            results[lottoRank] = results[lottoRank]?.plus(1) ?: 0
        }

        return LottosResult(
            totalCost = cost,
            winningResults = results.toMap(),
        )
    }

    operator fun plus(lottos: Lottos): Lottos {
        return Lottos(values + lottos.values)
    }

    companion object {
        fun random(countOfLottos: Int): Lottos {
            return Lottos(
                List(countOfLottos) { Lotto() },
            )
        }

        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}
