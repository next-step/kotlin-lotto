package lotto.controller

import lotto.domain.LottoNumber

class WinningNumbers(val numbers: Set<LottoNumber>, val bonusNumber: LottoNumber) {
    constructor(input: List<Int>, bonusNumber: Int)
            : this(input.map { LottoNumber(it) }.toSet(), LottoNumber(bonusNumber))
}
