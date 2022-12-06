package lotto.domain

import lotto.domain.vo.LottoNumber

class WinningNumbers(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    init {
        require(!lottoNumbers.contains(bonusNumber)) { "bonus number should be different number out of winning numbers" }
    }

    constructor(lottoNumbers: List<Int>, bonusNumber: Int) : this(lottoNumbers = LottoNumbers(lottoNumbers), bonusNumber = LottoNumber(bonusNumber))
}
