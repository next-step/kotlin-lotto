package lotto.entity

import lotto.domain.LottoMatchResult
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber

class LottoInfo(private val lottoNumbers: LottoNumber) {
    fun getNumbers(): Set<Int> = lottoNumbers.getNumbers()

    fun hasNumber(bonusNumber: Int): Boolean {
        return this.lottoNumbers.hasNumber(bonusNumber)
    }

    fun compareWithWinningNumbers(winningLottoNumber: WinningLottoNumber): LottoMatchResult {
        val matchCount = this.getNumbers().count { winningLottoNumber.hasWinningNumber(it) }
        val hasBonus = winningLottoNumber.hasBonusNumber(this)
        return LottoMatchResult(matchCount, hasBonus)
    }
}
