package lotto.domain

import lotto.common.IntegerNumberList
import lotto.util.NumberGenerator

class LottoGenerator(
    private val numberGenerator: NumberGenerator
) {
    fun generate(size: Int): List<Lotto> {
        return List(size) { Lotto(randomNumber()) }
    }

    private fun randomNumber(): List<LottoNumber> {
        return numberGenerator.generate(Lotto.LOTTO_START_NUMBER, Lotto.LOTTO_END_NUMBER, Lotto.LOTTO_NUMBERS_SIZE)
            .map { LottoNumber(it) }
    }

    fun generate(numberList: List<IntegerNumberList>): List<Lotto> {
        return numberList.map {
            val lottoNumberList = it.integerNumberList.map { number -> LottoNumber(number) }
            Lotto(lottoNumberList)
        }
    }
}
