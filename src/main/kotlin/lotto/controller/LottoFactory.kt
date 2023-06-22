package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.LottoNumberGenerator

class LottoFactory(private val lottoNumberGenerator: LottoNumberGenerator) {

    fun createLottos(manualLottoNumbers: List<LottoNumbers>, money: Int): Lottos {
        val randomLottoNumbers =
            List(calculateRandomLottoCount(money, manualLottoNumbers.size)) { createRandomLottoNumbers() }
        return Lottos(manualLottoNumbers + randomLottoNumbers)
    }

    private fun calculateRandomLottoCount(input: Int, manualLottoCount: Int): Int {
        return input / PER_LOTTO_PRICE - manualLottoCount
    }

    private fun createRandomLottoNumbers(): LottoNumbers {
        val lottoNumberList = lottoNumberGenerator.generateNumbers()
        return LottoNumbers(lottoNumberList)
    }

    companion object {
        private const val PER_LOTTO_PRICE = 1000
    }
}
