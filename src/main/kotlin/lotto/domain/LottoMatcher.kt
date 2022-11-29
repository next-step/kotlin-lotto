package lotto.domain

object LottoMatcher {

    fun matchingWinner(matchNumberCount: Int): Winner {
        check((Lotto.START_LOTTO_INDEX..Lotto.LAST_LOTTO_INDEX).contains(matchNumberCount)) { "당첨 개수는 최대 6개 최소 0개 입니다" }
        return Winner.safeValueOf(matchNumberCount)
    }

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
