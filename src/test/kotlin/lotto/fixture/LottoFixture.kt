package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber

internal fun Lotto.Companion.fixture(vararg numbers: Int): Lotto = Lotto(numbers.map(::LottoNumber))
