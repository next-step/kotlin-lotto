package lotto.domain

class WinningLotto(private val winningNumbers: List<LottoNumber>, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in winningNumbers) { ALREADY_USED_BONUS_NUMBER_ERROR_MSG }
    }

    fun getPrizes(lottos: List<Lotto>): List<LottoPrize> {
        return lottos
            .mapNotNull {
                val matchCount = it.countMatches(winningNumbers)
                val bonusMatch = it.checkBonusMatch(bonusNumber)
                LottoPrize.fromMatchCount(matchCount, bonusMatch)
            }
            .sortedBy { it.matchCount }
    }

    companion object {
        private const val ALREADY_USED_BONUS_NUMBER_ERROR_MSG = "보너스 번호가 이미 사용된 번호입니다."
    }
}
