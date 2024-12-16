package lotto.view.util

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

fun splitInputNumbersCommand(inputNumbersCommand: String): LottoNumbers {
    require(inputNumbersCommand.isNotBlank()) { INVALID_BLANK_NUMBERS_MESSAGE }
    require(inputNumbersCommand.contains(NUMBERS_DELIMITER)) {
        INVALID_DELIMITER_NUMBERS_MESSAGE
    }

    val lottoNumbers =
        inputNumbersCommand.split(NUMBERS_DELIMITER)
            .map { lottoNumberStringToInt(numberString = it.trim()) }
            .toSet()

    return LottoNumbers(lottoNumbers)
}

private fun lottoNumberStringToInt(numberString: String): LottoNumber {
    val lottoNumberOrNull = numberString.toIntOrNull()
    requireNotNull(lottoNumberOrNull) { INVALID_NUMBERS_TO_INT_MESSAGE }
    return LottoNumber.of(lottoNumberOrNull)
}

const val INVALID_BLANK_NUMBERS_MESSAGE: String = "입력된 로또 번호가 공백입니다"
const val INVALID_DELIMITER_NUMBERS_MESSAGE: String = "로또 번호 구분자가 올바르지 않습니다"
const val NUMBERS_DELIMITER: String = ","
const val INVALID_NUMBERS_TO_INT_MESSAGE: String = "로또 번호가 숫자로 입력되지 않았습니다"
