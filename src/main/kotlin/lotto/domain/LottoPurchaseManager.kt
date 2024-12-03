package lotto.domain

import lotto.domain.lottonumber.RandomLottoNumbersGenerator

object LottoPurchaseManager {
    fun purchaseLotto(amount: Int): List<Lotto> {
        val lottoCount = amount / Lotto.LOTTO_PRICE
        return List(lottoCount) { Lotto(RandomLottoNumbersGenerator().generate()) }
    }
}
