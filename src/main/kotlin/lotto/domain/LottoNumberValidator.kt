package lotto.domain

import calculator.Tokenizer
import lotto.domain.model.Lotto

object LottoNumberValidator {
    private const val LOTTO_NUMBER_COUNT = 6

    fun validate(lottoNumberString: String?): Boolean {
        check(lottoNumberString != null) { "입력 값이 null 이 될 수 없습니다." }

        val numbers: List<Int> = makeNumbers(lottoNumberString)

        if (numbers.isEmpty()) return false
        if (numbers.size != LOTTO_NUMBER_COUNT) return false

        return true
    }

    private fun makeNumbers(numberString: String): List<Int> {
        val numbers: List<Int> = Tokenizer.tokenize(numberString).map { string ->
            val number = string.toIntOrNull()
            check(number != null) { "입력된 값이 숫자가 아닙니다." }
            number
        }
        return numbers
    }

    fun validateBonus(bonusNumber: String): Boolean {
        if (bonusNumber.isBlank()) return false
        val numbers: List<Int> = makeNumbers(bonusNumber)
        if (numbers.isEmpty()) return false
        if (numbers.size != 1) return false
        return Lotto.LOTTO_NUMBER_RANGE.contains(numbers[0])
    }
}
