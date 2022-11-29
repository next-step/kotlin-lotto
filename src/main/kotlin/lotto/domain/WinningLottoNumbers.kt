package lotto.domain

data class WinningLottoNumbers(
    private val lottoNumbers: LottoNumbers,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!lottoNumbers.lottoNumbers.contains(bonusLottoNumber)) { INVALID_BONUS_BALL_ERROR_MESSAGE }
    }
    fun getMatchResult(lotteries: List<LottoNumbers>): List<Pair<Int, Boolean>> {
        return lotteries.map {
            Pair(lottoNumbers.getNumberOfMatch(it), it.isMatchBonusLottoNumber(bonusLottoNumber))
        }
    }

    companion object {
        private const val INVALID_BONUS_BALL_ERROR_MESSAGE = "보너스 볼은 당첨 번호와 중복되지 않는 수여야 합니다."
    }
}
