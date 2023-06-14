package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber

internal fun Lotto.Companion.of(vararg values: Int): Lotto = values.toList()
    .map(LottoNumber::valueOf)
    .toSet()
    .let(::Lotto)
