package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val size = values.size
    val cost = size * Lotto.PRICE

    fun calculateResults(
        winningNumbers: LottoNumbers,
        bonusNumber: LottoNumber,
    ): LottosResult {
        val results = LottoRank.createMapWithLottoRankAndZero()
        values.forEach { lotto ->
            val lottoRank =
                lotto.calculateResult(winningNumbers = winningNumbers, bonusNumber = bonusNumber) ?: return@forEach
            results[lottoRank] = results[lottoRank]?.plus(1) ?: 0
        }

        return LottosResult(
            totalCost = cost,
            winningResults = results.toMap(),
        )
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
