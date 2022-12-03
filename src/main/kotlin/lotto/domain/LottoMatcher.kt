package lotto.domain

object LottoMatcher {

    fun matchingWinner(matchCount: Int, matchBonus: Boolean): Rank {
        check((Lotto.START_LOTTO_INDEX..Lotto.LAST_LOTTO_INDEX).contains(matchCount)) { "당첨 개수는 최대 6개 최소 0개 입니다" }
        return Rank.safeValueOf(matchCount = matchCount, matchBonus = matchBonus)
    }

    fun countMatchNumber(winningNumbers: List<Int>, lottoNumbers: List<Int>): Int {
        return winningNumbers.sumOf {
            checkContainWinningNumber(winningNumber = it, lottoNumbers = lottoNumbers)
        }
    }

    fun matchBonus(matchCount: Int, lottoNumbers: List<Int>, bonusNumber: Int): Boolean {
        return matchCount == 5 && lottoNumbers.contains(bonusNumber)
    }

    private fun checkContainWinningNumber(winningNumber: Int, lottoNumbers: List<Int>): Int {
        return if (lottoNumbers.contains(winningNumber)) 1 else 0
    }
}
