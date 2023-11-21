package lotto.domain

import lotto.error.InvalidWinningLottoException

data class WinningLotto(
    val winningNumber: LottoNumber,
    val bonusNumber: Int,
) {
    init {
        LottoNumber.checkCanInclude(bonusNumber)
        require(!winningNumber.contains(bonusNumber)) {
            throw InvalidWinningLottoException("보너스 볼과 당첨번호 숫자가 중복됩니다")
        }
    }

    fun rank(number: LottoNumber): LottoRank {
        val matchedCount = winningNumber countMatched number
        val matchesBonus = number contains bonusNumber
        return LottoRank.valueOf(matchedCount, matchesBonus)
    }
}
