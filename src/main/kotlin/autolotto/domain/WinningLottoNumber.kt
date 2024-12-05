package autolotto.domain

import autolotto.entity.Lotto

class WinningLottoNumber(private val winningNumbers: Set<Int>, private val bonusNumber: Int) {
    init {
        require(this.winningNumbers.size == WINNING_NUMBER_LENGTH) { "당첨 번호는 6개를 입력해야합니다." }
        require(bonusNumber in MIN_BONUS_NUMBER..MAX_BONUS_NUMBER) { "보너스는 번호는 1부터 45까지의 숫자중 하나여야합니다." }
        require(!this.winningNumbers.contains(this.bonusNumber)) { "보너스번호는 당첨번호와 다른 숫자를 입력해야합니다." }
    }

    fun isHasWinningNumber(number: Int): Boolean {
        return this.winningNumbers.contains(number)
    }

    fun isHasBonusNumber(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(this.bonusNumber)
    }

    companion object {
        private const val WINNING_NUMBER_LENGTH = 6
        private const val MIN_BONUS_NUMBER = 1
        private const val MAX_BONUS_NUMBER = 45
    }
}
