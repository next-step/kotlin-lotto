package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val lottoQuantity: LottoQuantity = LottoQuantity(values.size)
    val totalCost: Money = Money(lottoQuantity.value * Lotto.PRICE)

    fun calculateResults(
        winningLotto: WinningLotto,
    ): LottosResult {
        val results = LottoRank.createMapWithLottoRankAndZero()
        values.forEach { lotto ->
            val lottoRank = winningLotto.match(lotto) ?: return@forEach
            results[lottoRank] = results[lottoRank]?.plus(1) ?: 0
        }

        return LottosResult(
            totalCost = totalCost,
            winningResults = results.toMap(),
        )
    }

    operator fun plus(lottos: Lottos): Lottos {
        return Lottos(values + lottos.values)
    }

    companion object {
        fun random(lottoQuantity: LottoQuantity): Lottos {
            return Lottos(
                List(lottoQuantity.value) { Lotto() },
            )
        }

        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}
