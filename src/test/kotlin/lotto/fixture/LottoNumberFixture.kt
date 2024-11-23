package lotto.fixture

import lotto.LottoNumber

internal fun lottoNumbersFixture(vararg numbers: Int): Set<LottoNumber> = numbers.map(::LottoNumber).toSet()
