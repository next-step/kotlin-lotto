package lotto.fixture

import lotto.Lotto
import lotto.LottoNumber

internal fun Lotto.Companion.fixture(vararg numbers: Int): Lotto = Lotto(numbers.map(::LottoNumber))
