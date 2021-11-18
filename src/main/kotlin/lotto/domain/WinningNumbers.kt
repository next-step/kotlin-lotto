package lotto.domain

class WinningNumbers(val winningNumbers: List<Int>, bonusNumber: Int) {
    val bonusNumber: Int = bonusNumber.also { isInWinningNumbers(bonusNumber) }

    private fun isInWinningNumbers(bonusNumber: Int): Boolean {
        require(!winningNumbers.contains(bonusNumber)) {
            "당첨 번호안에 보너스 번호가 포함되어 있습니다."
        }
        return true
    }
}
