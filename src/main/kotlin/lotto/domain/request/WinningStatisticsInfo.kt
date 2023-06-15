package lotto.domain.request

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.WinningInfo

data class WinningStatisticsInfo(
    val money: Long,
    val winningNumbers: List<Int>,
    val bonusNumber: Int,
    val lottos: Lottos
) {
    init {
        validateMoney(money)
        validateWinningNumbers(winningNumbers)
    }

    private fun validateMoney(money: Long) {
        require(money >= Lotto.PRICE.value) {
            "돈은 ${Lotto.PRICE} 이상 이어야 합니다."
        }
    }

    private fun validateWinningNumbers(winningNumbers: List<Int>) {
        val filteredNumbers = winningNumbers.toSet()

        require(filteredNumbers.size == WinningInfo.WINNING_NUMBERS_VALID_LENGTH) {
            "당첨 번호는 중복되지 않는 6개의 번호여야 합니다. Input: $winningNumbers"
        }
    }
}
