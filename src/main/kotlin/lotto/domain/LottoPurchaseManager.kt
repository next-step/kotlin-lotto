package lotto.domain

import lotto.domain.lottonumber.RandomLottoNumbersGenerator

object LottoPurchaseManager {
    private const val LOTTO_PRICE = 1000

    fun purchaseLotto(amount: Int): List<Lotto> {
        val lottoCount = amount / LOTTO_PRICE
        return List(lottoCount) { Lotto.from(RandomLottoNumbersGenerator().generate()) }
    }
}
