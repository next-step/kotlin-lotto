package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.NumberGenerator

class LottoFactory(private val numberGenerator: NumberGenerator) {

    fun createLottos(manualLottoNumbers: List<LottoNumbers>, money: Int): Lottos {
        val randomLottoNumbers =
            List(calculateRandomLottoCount(money, manualLottoNumbers.size)) { createRandomLottoNumbers() }
        return Lottos(manualLottoNumbers + randomLottoNumbers)
    }

    private fun calculateRandomLottoCount(input: Int, manualLottoCount: Int): Int {
        return input / PER_LOTTO_PRICE - manualLottoCount
    }

    fun createManualLottoNumbers(input: List<List<Int>>): List<LottoNumbers> {
        return input.map { createManualLottoNumber(it) }
    }

    private fun createManualLottoNumber(input: List<Int>): LottoNumbers {
        val lottoNumberList = input.map { LottoNumber(it) }
        return LottoNumbers(lottoNumberList)
    }

    private fun createRandomLottoNumbers(): LottoNumbers {
        val lottoNumberList = numberGenerator.generateNumbers()
        return LottoNumbers(lottoNumberList)
    }

    companion object {
        private const val PER_LOTTO_PRICE = 1000
    }
}
