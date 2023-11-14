package lotto.domain

import lotto.service.NumberCreateStrategy

class LottoBundle(
    val bundle: List<Lotto>
) {
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
