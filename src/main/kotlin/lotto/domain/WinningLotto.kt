package lotto.domain

import lotto.util.ErrorCode

class WinningLotto(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!winningLotto.containLottoNumber(bonusLottoNumber)) {
            ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage
        }
    }

    fun compare(lotto: Lotto): LottoRank {
        val matchCount = winningLotto.getMatchCount(lotto)
        val isBonusMatch = lotto.containLottoNumber(bonusLottoNumber)
        return LottoRank.valueOf(matchCount, isBonusMatch)
    }
}
