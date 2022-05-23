package lotto.model.data

import org.assertj.core.util.VisibleForTesting

@VisibleForTesting
fun String.toLottoNumber(): LottoNumber {
    return LottoNumber(this.trim().toInt())
}

@VisibleForTesting
fun String.toLottoNumberList() =
    this.split(",").map { it.toLottoNumber() }

@VisibleForTesting
fun String.toLottoNumberSet() =
    this.toLottoNumberList().toSet()
