package lotto.domain

class WinningNumbers(
    val numbers: LottoNumbers,
) {
    fun matchNumbers(lotto: Lotto): Int {
        return lotto.numbers.lottoNumbers.filter { isInWinningNumbers(it) }.size
    }

    private fun isInWinningNumbers(number: LottoNumber): Boolean {
        return numbers.lottoNumbers.map { it.number }.contains(number.number)
    }
}
