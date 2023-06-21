package lotto

class WinningLotto(
    private val winNumbers: List<LottoNumber>,
    private val bonusNumbers: List<LottoNumber>
) {
    init {
        val duplicateBetweenWinNumberAndBonusNumber = bonusNumbers.any { winNumbers.contains(it) }
        require(!duplicateBetweenWinNumberAndBonusNumber) { "당첨번호와 동일한 보너스 볼이 나올 수 없습니다" }
        assertNoDuplicateLottoNumber(winNumbers)
        assertNoDuplicateLottoNumber(bonusNumbers)
    }

    fun countMatch(lotto: Lotto) = MatchResult(
        winNumberMatchCount = match(winNumbers, lotto),
        bonusNumberMatchCount = match(bonusNumbers, lotto)
    )

    private fun match(numbers: List<LottoNumber>, lotto: Lotto) = numbers.count { lotto.isContainLottoNumber(it) }

    private fun assertNoDuplicateLottoNumber(numbers: List<LottoNumber>) {
        require(numbers.size == numbers.distinct().size) { "중복되는 당첨번호가 존재합니다." }
    }

    data class MatchResult(
        private val winNumberMatchCount: Int,
        private val bonusNumberMatchCount: Int
    ) {
        fun getTotalMatch() = winNumberMatchCount + bonusNumberMatchCount

        private fun isBonusMatched() = bonusNumberMatchCount != 0

        fun toRank() = Rank.of(getTotalMatch(), isBonusMatched())
    }
}
