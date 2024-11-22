package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.Number

fun createLottoFixture(numbers: List<Int>): Lotto = Lotto(numbers.map { Number(it) })
