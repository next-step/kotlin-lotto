package lotto.domain

import calculator.Tokenizer
import lotto.domain.model.Lotto

object LottoNumberValidator {
    private const val LOTTO_NUMBER_COUNT = 6

    fun validate(lottoNumberText: String?): Boolean {
        check(lottoNumberText != null) { "입력 값이 null 이 될 수 없습니다." }

        val numbers: List<Int> = makeNumbers(lottoNumberText)

        if (numbers.isEmpty()) return false
        if (numbers.size != LOTTO_NUMBER_COUNT) return false

        return true
    }

    private fun makeNumbers(numberText: String): List<Int> {
        val numbers: List<Int> = Tokenizer.tokenize(numberText).map { numberText ->
            val number = numberText.toIntOrNull()
            check(number != null) { "입력된 값이 숫자가 아닙니다." }
            number
        }
        return numbers
    }

    fun validateBonus(bonusNumberText: String): Boolean {
        if (bonusNumberText.isBlank()) return false
        val numbers: List<Int> = makeNumbers(bonusNumberText)
        if (numbers.isEmpty()) return false
        if (numbers.size != 1) return false
        return Lotto.LOTTO_NUMBER_RANGE.contains(numbers[0])
    }
}
