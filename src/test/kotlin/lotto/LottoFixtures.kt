package lotto

fun createLotto(vararg numbers: Int): Lotto {
    return Lotto(numbers.map { LottoNumber(it) }.toSet())
}

fun createWinningNumber(vararg numbers: Int): WinningNumber {
    return WinningNumber(numbers.map { LottoNumber(it) }.toSet())
}
