package lotto.domain

data class WinningLottoNumbers(
    private val lottoNumbers: LottoNumbers,
    private val bonusLottoNumbers: LottoNumber
) {
    init {
        require(!lottoNumbers.lottoNumbers.contains(bonusLottoNumbers)) { INVALID_BONUS_BALL_ERROR_MESSAGE }
    }
    fun getAllNumberOfMatches(lotteries: List<LottoNumbers>): List<Int> {
        return lotteries.map {
            lottoNumbers.getNumberOfMatch(it)
        }
    }

    companion object {
        private const val INVALID_BONUS_BALL_ERROR_MESSAGE = "보너스 볼은 당첨 번호와 중복되지 않는 수여야 합니다."
    }
}
