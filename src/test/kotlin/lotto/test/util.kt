package lotto.test

import lotto.vo.LottoNumber

internal fun lottoNumbersOf(vararg numbers: Int) = numbers.map(LottoNumber::from)
