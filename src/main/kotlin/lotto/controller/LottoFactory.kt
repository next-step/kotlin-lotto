package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.NumberGenerator

class LottoFactory(private val numberGenerator: NumberGenerator) {

    fun createLottos(input: Int): Lottos {
        val count = input / PER_LOTTO_PRICE
        val lottoList = List(count) { LottoNumbers(numberGenerator) }
        return Lottos(lottoList)
    }
    companion object {
        private const val PER_LOTTO_PRICE = 1000
    }
}
