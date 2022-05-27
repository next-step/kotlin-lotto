package lotto

import lotto.numbers.LottoNumbersGenerator
import lotto.numbers.RandomNumbersGenerator

class Lotto(val price: Int = DEFAULT_PRICE, numbersGenerator: LottoNumbersGenerator = RandomNumbersGenerator) {
    val numbers: List<Int> = numbersGenerator.generate()

    companion object {
        private const val DEFAULT_PRICE: Int = 1000
    }
}
