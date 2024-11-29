package lotto.domain

import lotto.domain.lottonumber.RandomLottoNumbersGenerator

object LottoPurchaseController {
    private const val LOTTO_PRICE = 1000

    fun purchaseLotto(amount: Int): List<Lotto> = LottoGenerator.generateLottos(amount / LOTTO_PRICE, RandomLottoNumbersGenerator())
}
