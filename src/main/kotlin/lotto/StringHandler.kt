package lotto

import lotto.domain.LottoNumber

fun tokenizeWinningNumbers(input: String): List<LottoNumber> {
    return input
        .split(",")
        .filterNot { it.isBlank() }
        .map { LottoNumber.from(it.trim().toInt()) }
}
