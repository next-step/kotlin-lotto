package lotto.domain

import lotto.entity.LottoInfo

class WinningLottoNumber(private val winningNumbers: LottoNumber, val bonusNumber: Int) {
    init {
        require(bonusNumber in MIN_BONUS_NUMBER..MAX_BONUS_NUMBER) {
            "보너스 번호는 1~45 사이여야 합니다."
        }
        require(winningNumbers.hasNotNumber(bonusNumber)) {
            "보너스 번호는 당첨 번호와 달라야 합니다."
        }
    }

    fun hasWinningNumber(number: Int): Boolean {
        return winningNumbers.hasNumber(number)
    }

    fun hasBonusNumber(lottoInfo: LottoInfo): Boolean {
        return lottoInfo.hasNumber(bonusNumber)
    }

    companion object {
        private const val MIN_BONUS_NUMBER = 1
        private const val MAX_BONUS_NUMBER = 45
    }
}
