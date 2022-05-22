package lotto.util

import lotto.domain.LottoNumbers

fun interface LottoNumberGenerator {
    fun generate(): LottoNumbers
}
