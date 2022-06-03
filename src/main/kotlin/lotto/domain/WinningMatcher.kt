package lotto.domain

class WinningMatcher(private val winningNumbers: LottoNumbers) {

    fun getMatchGrade(lottoNumbers: LottoNumbers): Grade {
        val matchCount = winningNumbers.matchCount(lottoNumbers)
        return Grade.find(matchCount)
    }
}
