package lotto.domain

class LottoWinningNumbers(
    val winningNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    init {
        require(winningNumbers.lottoNumbers.size == LOTTO_WINNING_NUMBERS_SIZE) { "당첨번호 수가 잘못되었습니다." }
    }

    fun match(lottoNumbers: LottoNumbers): LottoMatchCount {
        val matchCount = lottoNumbers.getMatchCount(winningNumbers)
        val containsBonusNumber = lottoNumbers.containsBonusNumber(bonusNumber)

        return LottoMatchCount(matchCount = matchCount, containsBonusNumber = containsBonusNumber)
    }

    companion object {

        private const val LOTTO_WINNING_NUMBERS_SIZE = 7

        fun of(winningNumbers: List<Int>, bonusNumber: Int): LottoWinningNumbers {
            val lottoBonusNumber = LottoNumber(bonusNumber)
            return LottoWinningNumbers(
                winningNumbers = LottoNumbers.of(winningNumbers.map { it }, bonusNumber),
                bonusNumber = lottoBonusNumber
            )
        }
    }
}
