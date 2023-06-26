package step2Lotto.domain

class WinningNumber(numbers: Array<Int>) : Lotto(numbers.map { LottoNumber(it) })
