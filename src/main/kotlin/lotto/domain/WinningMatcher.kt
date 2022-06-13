package lotto.domain

class WinningMatcher(private val winningNumbers: LottoNumbers, private val bonus: LottoNumber) {

    init {
        require(bonus !in winningNumbers) { "보너스 번호와 동일한 번호가 당첨 번호에 포함되지 않아야 합니다." }
    }

    fun getMatchGrade(lottoNumbers: LottoNumbers): Grade {
        val matchCount = lottoNumbers.matchCount(winningNumbers)
        val matchBonus = bonus in lottoNumbers
        return Grade.find(matchCount, matchBonus)
    }
}
