package lotto.domain

data class WinningStatisticsInfo(
    val money: Int,
    val winningNumbers: List<String>,
    val bonusNumber: Int,
    val lottos: Lottos
) {
    init {
        validateMoney(money)
        validateWinningNumbers(winningNumbers)
    }

    private fun validateMoney(money: Int) {
        require(money >= Lotto.PRICE.value) {
            "돈은 ${Lotto.PRICE} 이상 이어야 합니다."
        }
    }

    private fun validateWinningNumbers(winningNumbers: List<String>) {
        val filteredNumbers = winningNumbers.map(String::trim).mapNotNull(String::toIntOrNull).toSet()

        require(filteredNumbers.size == WinningInfo.WINNING_NUMBERS_VALID_LENGTH) {
            "당첨 번호는 중복되지 않는 6개의 번호여야 합니다. Input: $winningNumbers"
        }
    }
}
