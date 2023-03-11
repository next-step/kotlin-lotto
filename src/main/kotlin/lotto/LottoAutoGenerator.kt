package lotto

import lotto.LottoGeneratorStrategy.Companion.ALL_LOTTO_NUMBERS

class LottoAutoGenerator : LottoGeneratorStrategy {

    override fun generate(count: Int): List<LottoNumbers> {
        return (1..count).map { generateLottoNumber() }
    }

    private fun generateLottoNumber(): LottoNumbers {
        return LottoNumbers(
            ALL_LOTTO_NUMBERS
                .shuffled()
                .slice(0 until 6)
                .sorted()
                .map { LottoNumber(it) }
        )
    }
}
