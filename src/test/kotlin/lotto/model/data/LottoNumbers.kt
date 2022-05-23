package lotto.model.data

import org.assertj.core.util.VisibleForTesting

@VisibleForTesting
fun String.toLottoNumber(): LottoNumber {
    return LottoNumber(this.trim().toInt())
}

@VisibleForTesting
fun String.toLottoNumbers() =
    CommaSeparatedInt(this).toLottoNumbers()
