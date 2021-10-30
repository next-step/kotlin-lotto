package lotto.usecase

import lotto.domain.Lotto

class LottoMachine(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {

    fun buy(purchaseAmount: Int): List<Lotto> {
        val numberOfPurchase = purchaseAmount / LOTTO_PRICE

        return (1..numberOfPurchase).map {
            Lotto(
                numbers = lottoNumberGenerator.generate(),
                price = LOTTO_PRICE,
            )
        }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
