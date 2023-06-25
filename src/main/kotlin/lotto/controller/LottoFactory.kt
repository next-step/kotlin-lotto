package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.LottoNumberGenerator

class LottoFactory(private val lottoNumberGenerator: LottoNumberGenerator) {

    fun createRandomLottos(count: Int): Lottos {
        val randomLottoNumbers = List(count) { createRandomLottoNumbers() }
        return Lottos(randomLottoNumbers)
    }

    private fun createRandomLottoNumbers(): LottoNumbers {
        val lottoNumberList = lottoNumberGenerator.generateNumbers()
        return LottoNumbers(lottoNumberList)
    }

    companion object {
        const val PER_LOTTO_PRICE = 1000
    }
}
