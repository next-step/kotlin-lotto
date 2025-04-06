package lotto.controller

import lotto.domain.LottoNumber

class WinningNumbers(val numbers: Set<LottoNumber>) {
    constructor(input: List<Int>) : this(input.map { LottoNumber(it) }.toSet())
}
