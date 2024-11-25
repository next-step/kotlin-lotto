package lotto.fixture

import lotto.domain.DefaultLotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningLotto

internal fun lottoFixture(vararg numbers: Int): DefaultLotto = DefaultLotto(lottoNumbersFixture(*numbers))

internal fun winningLottoFixture(
    vararg numbers: Int,
    bonusNumber: Int,
): WinningLotto = WinningLotto(lottoNumbersFixture(*numbers), LottoNumber(bonusNumber))

internal fun lottosFixture(vararg lottos: DefaultLotto): Lottos = Lottos(lottos.toList())

internal fun lottosFixture(vararg numbers: Int): Lottos = Lottos(listOf(lottoFixture(*numbers)))
