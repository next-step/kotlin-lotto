package lotto.domain

class WinningNumbers(
    val winningNumbers: LottoNumbers,
    val bonusnumber: LottoNumber,
) {
    init {
        require(!winningNumbers.containNumber(bonusnumber.number)) { "Bonus must not in winningNumbers" }
    }

    fun matchNumbers(lotto: Lotto): Int {
        return lotto.numbers.lottoNumbers.filter { isInWinningNumbers(it) }.size
    }

    private fun isInWinningNumbers(number: LottoNumber): Boolean {
        return winningNumbers.containNumber(number.number)
    }
}
