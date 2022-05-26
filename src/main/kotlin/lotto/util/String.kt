package lotto.util

import lotto.domain.LottoNumber

fun String.toLottoNumbers(delimiters: String): List<LottoNumber> {
    return runCatching {
        this.split(delimiters).map { LottoNumber(it.toInt()) }
    }.getOrThrow()
}
