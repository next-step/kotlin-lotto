package lotto.core

import lotto.core.constant.LottoConstants

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    constructor(numbers: List<LottoNumber>, bonusNumber: LottoNumber) : this(Lotto(numbers), bonusNumber)

    init {
        require(bonusNumber !in lotto) { LottoConstants.ERROR_INVALID_BONUS_NUMBER }
    }

    fun checkWinningState(lotto: Lotto): WinningRank {
        return WinningRank.getRank(this.lotto.countSameNumbers(lotto), lotto.contains(bonusNumber))
    }
}
