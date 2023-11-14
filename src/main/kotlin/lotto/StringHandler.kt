package lotto

import lotto.domain.LottoNumber

fun tokenizeWinningNumbers(input: String): List<LottoNumber> {
    return input
        .split(",")
        .filterNot { it.isBlank() }
        .map { LottoNumber.from(it.trim().toInt()) }
}

fun inputToInt(input: String): Int {
    try {
        return input.toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("입력은 숫자로만 구성되어야 합니다.")
    }
}
