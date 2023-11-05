package lotto.domain

class LottoWinningNumber(private val numbers: LottoNumbers, private val bonusNumber: LottoNumber) {

    fun evaluateMatchResult(lottoNumbers: LottoNumbers): MatchResult = MatchResult(
        count = lottoNumbers.getMatchCount(numbers),
        matchBonus = lottoNumbers.contains(bonusNumber)
    )
}
