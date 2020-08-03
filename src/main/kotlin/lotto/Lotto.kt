package lotto

import lotto.generator.LottoNumberGenerater
import lotto.generator.RandomNumberGenerater

data class Lotto(
    val generator: LottoNumberGenerater = RandomNumberGenerater
) {
    private var numbers: Numbers = generator.generate()

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6

        fun newAutoInstance() = Lotto()
    }
}
