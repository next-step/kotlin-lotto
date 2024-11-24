package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.Lottos

internal fun lottoFixture(vararg numbers: Int): Lotto = Lotto.of(numbers.toList())

internal fun lottosFixture(vararg lottos: Lotto): Lottos = Lottos(lottos.toList())

internal fun lottosFixture(vararg numbers: Int): Lottos = Lottos(listOf(lottoFixture(*numbers)))
