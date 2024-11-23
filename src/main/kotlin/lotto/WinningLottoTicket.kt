package lotto

class WinningLottoTicket(
    val winningNumbers: Set<Int>,
    val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == 6) {
            "로또 번호는 6개여야 합니다."
        }

        require(winningNumbers.none { it == bonusNumber }) {
            "보너스 번호는 당첨 번호와 중복되면 안됩니다."
        }
    }
}
