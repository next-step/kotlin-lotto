package lotto.util

import lotto.domain.LottoNumber

object Assertions {
    fun assertLotto(actual: List<LottoNumber>): LottoAssert =
        LottoAssert(actual)
    fun assertWinningNumbers(actual: List<LottoNumber>): WinningLottoAssert =
        WinningLottoAssert(actual)
}
