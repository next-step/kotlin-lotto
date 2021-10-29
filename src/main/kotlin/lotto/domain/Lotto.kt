package lotto.domain

@JvmInline
value class Lotto(
    val lottoNumbers: List<Int>,
) {
    fun matchWinningNumber(winningNumbers: List<Int>): Int {
        return winningNumbers.count { containsLottoNumbers(it) }
    }

    private fun containsLottoNumbers(winningNumber: Int): Boolean = lottoNumbers.contains(winningNumber)
}
