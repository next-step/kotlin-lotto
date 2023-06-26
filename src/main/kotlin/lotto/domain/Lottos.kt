package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val lottoQuantity: LottoQuantity = LottoQuantity(values.size)
    val totalCost: Money = Money(lottoQuantity.value * Lotto.PRICE)

    val manual: Lottos
        get() = Lottos(values.filter { it.type == LottoType.MANUAL })

    val auto: Lottos
        get() = Lottos(values.filter { it.type == LottoType.AUTO })

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
        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}
