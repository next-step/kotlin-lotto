package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos

class LottoShop(private val lottoFactory: LottoFactory) {

    fun purchaseLottos(manualLottoNumbers: List<LottoNumbers>, money: Int): Lottos {
        val manualLottos = Lottos(manualLottoNumbers)
        val randomLottoCount = calculateRandomLottoCount(money, manualLottoNumbers.size)
        val randomLottos = lottoFactory.createRandomLottos(randomLottoCount)
        return manualLottos + randomLottos
    }

    private fun calculateRandomLottoCount(input: Int, manualLottoCount: Int): Int {
        return input / LottoFactory.PER_LOTTO_PRICE - manualLottoCount
    }
}
