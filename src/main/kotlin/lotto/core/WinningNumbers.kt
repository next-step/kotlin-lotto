package lotto.core

import lotto.core.constant.LottoConstants

class WinningNumbers(numbers: List<Int>, private val bonusNumber: Int) {
    private val lotto: Lotto = Lotto(numbers)

    init {
        require(LottoConstants.LOTTO_NUMBER_MIN <= bonusNumber && bonusNumber <= LottoConstants.LOTTO_NUMBER_MAX ) { LottoConstants.ERROR_INVALID_NUMBER_SCOPE}
        require(!lotto.contains(bonusNumber)) { LottoConstants.ERROR_INVALID_BONUS_NUMBER }
    }

    fun checkWinningState(lotto: Lotto): WinningRank {
        return WinningRank.getRank(this.lotto.countCommonNumbers(lotto), lotto.contains(bonusNumber))
    }
}
