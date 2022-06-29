package lotto.entity

class LottoNumber(val winningNumbers: List<Int>, val bonusNumber: Int) {
    fun getWinningNumbersSet(): Set<Int> {
        return this.winningNumbers.toSet()
    }
}
