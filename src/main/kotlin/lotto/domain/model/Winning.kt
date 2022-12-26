package lotto.domain.model

class Winning(val winningNumbers: WinningNumbers, val bonusNumber: LottoNumber) {

    fun countMatchNumber(lotto: Lotto): Int {
        return winningNumbers.numbers.sumOf { winningNumber ->
            checkContainWinningNumber(winningNumber, lotto)
        }
    }

    private fun checkContainWinningNumber(winningNumber: LottoNumber, lotto: Lotto): Int {
        return if (lotto.contains(winningNumber)) 1 else 0
    }
}
