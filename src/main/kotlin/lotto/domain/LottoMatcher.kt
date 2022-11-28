package lotto.domain

object LottoMatcher {

    fun countMatchNumber(winningNumbers: List<Int>, lottoNumbers: List<Int>): Int {
        var count = 0
        winningNumbers.forEach { winningNumber ->
            count += checkContainWinningNumber(winningNumber = winningNumber, lottoNumbers = lottoNumbers)
        }
        return count
    }

    private fun checkContainWinningNumber(winningNumber: Int, lottoNumbers: List<Int>): Int {
        return if (lottoNumbers.contains(winningNumber)) 1 else 0
    }
}
