package lotto.domain

class LottoNumberMatcher(val winningNumbers: WinningNumbers) {
    fun matchNumbers(lotto: Lotto): Int {
        return lotto.numbers.filter { winningNumbers.isInWinningNumbers(it) }.size
    }
}
