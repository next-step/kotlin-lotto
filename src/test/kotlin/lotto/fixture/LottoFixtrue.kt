package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.Number
import lotto.domain.WinningLotto

fun createLottoFixture(numbers: List<Int>): Lotto = Lotto(numbers.map { Number(it) })

fun createWinningLottoFixture(
    numbers: List<Int>,
    bonus: Int,
): WinningLotto = WinningLotto(Lotto(numbers.map { Number(it) }), Number(bonus))
