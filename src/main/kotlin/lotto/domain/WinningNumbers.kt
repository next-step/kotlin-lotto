package lotto.domain

import lotto.domain.vo.LottoNumber

class WinningNumbers(private val winningNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    init {
        require(!winningNumbers.contains(bonusNumber)) { "bonus number should be different number out of winning numbers" }
    }

    constructor(lottoNumbers: List<Int>, bonusNumber: Int) : this(winningNumbers = LottoNumbers(lottoNumbers), bonusNumber = LottoNumber(bonusNumber))

    fun matchPrize(lottoNumbers: LottoNumbers): WinningPrize {
        val hasBonusNumber = lottoNumbers.contains(bonusNumber)
        val matchedCount = winningNumbers.countMatchedNumbers(lottoNumbers)

        return WinningPrize.find(matchedCount, hasBonusNumber)
    }
}
