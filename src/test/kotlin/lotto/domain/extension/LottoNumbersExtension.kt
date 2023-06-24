package lotto.domain.extension

import lotto.domain.LottoNumbers

fun lottoNumbers(vararg numbers: Int) = LottoNumbers.from(numbers.toSet())
