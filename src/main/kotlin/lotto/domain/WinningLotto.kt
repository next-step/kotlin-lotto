package lotto.domain

class WinningLotto(val winningNumbers: Lotto) {
    fun countMatchingNumbers(targetLotto: Lotto): Int {
        return targetLotto.numbers.count { it in winningNumbers.numbers }
    }
}
