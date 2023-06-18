package lotto.domain

class WinningLottoNumber(
    private val winningNumbers: LottoNumbers,
    private val bonusLottoNumber: LottoNumber,
) {

    init {
        val duplicatedNumber = winningNumbers.contains(bonusLottoNumber)
        require(!duplicatedNumber) { "보너스 번호가 이미 당첨 번호에 있습니다." }
    }

    fun getRanking(lottoNumbers: LottoNumbers): LottoRanking {
        val matchCount = lottoNumbers.count { winningNumbers.contains(it) }
        val matchBonus = lottoNumbers.any { it == bonusLottoNumber }
        return LottoRanking.valueOf(matchCount, matchBonus)
    }
}
