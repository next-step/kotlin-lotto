package lotto.domain

data class LottoTicket(private val generateLottoNumbers: () -> Set<Int>) {
    val lottoNumbers = generateLottoNumbers()

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
        require((LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().containsAll(lottoNumbers)) {
            INVALID_WINNER_NUMBERS_RANGE_MESSAGE
        }
    }

    fun checkLottoWinnerNumbersMatchPayout(winnerNumbers: LottoWinnerNumbers): LottoNumberMatchPayout {
        val matchCount = lottoNumbers.intersect(winnerNumbers.winnerNumbers).size
        return LottoNumberMatchPayout.byMatchCount(matchCount)
    }

    companion object {
        const val LOTTO_NUMBER_MIN_VALUE: Int = 1
        const val LOTTO_NUMBER_MAX_VALUE: Int = 45
        const val LOTTO_NUMBER_COUNT: Int = 6
        const val INVALID_LOTTO_NUMBER_COUNT_MESSAGE: String = "자동 생성된 로또 번호가 6개가 아닙니다"
        const val INVALID_WINNER_NUMBERS_RANGE_MESSAGE: String = "로또 당첨 번호는 1부터 45 사이 여야 합니다"
    }
}
