package lotto.domain

import lotto.service.NumberCreateStrategy

class LottoBundle(
    lottos: List<Lotto> = listOf()
) {

    val bundle: List<Lotto> = lottos

    fun showAllPurchaseLottoNumbers(): List<List<Int>> {
        return List(bundle.size) { index ->
            bundle[index].lotto.map { lottoNumber ->
                lottoNumber.number
            }.sortedBy {
                it
            }
        }
    }

    companion object {
        fun of(
            quantity: Int,
            strategy: NumberCreateStrategy
        ): LottoBundle {
            val numbersByQuantity = strategy.makeNumbersByQuantity(quantity)

            return List(numbersByQuantity.size) { index ->
                Lotto.from(numbersByQuantity[index].randomNumbers)
            }.let {
                LottoBundle(it)
            }
        }
    }
}
