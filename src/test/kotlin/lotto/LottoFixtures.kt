package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningNumber

fun createLotto(vararg numbers: Int): Lotto {
    return Lotto(numbers.map { LottoNumber(it) }.toSet())
}

fun createWinningNumber(vararg numbers: Int): WinningNumber {
    return WinningNumber(numbers.map { LottoNumber(it) }.toSet())
}
