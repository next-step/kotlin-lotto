package lotto.domain

import lotto.domain.numbers.LottoNumbersGenerator
import lotto.domain.numbers.RandomNumbersGenerator

class Lotto(numbersGenerator: LottoNumbersGenerator = RandomNumbersGenerator) {
    val numbers: List<Int> = numbersGenerator.generate()

    companion object {
        const val PRICE: Int = 1000
    }
}
