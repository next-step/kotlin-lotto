package lotto.domain

class LottoWinningNumbers(private val winningLotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(winningLotto.contains(bonusNumber).not()) { "보너스 번호는 중복되면 안됩니다." }
    }

    fun getLottoResult(lottos: List<Lotto>): LottoResult {
        val result = lottos.map { getRank(it) }
        return LottoResult(result)
    }

    private fun getRank(lotto: Lotto): LottoRank {
        val matchingCount = lotto.getMatchingCount(winningLotto)
        val isBonusMatch = lotto.contains(bonusNumber)
        return LottoRank.of(matchingCount, isBonusMatch)
    }

    companion object {
        fun of(winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber): LottoWinningNumbers {
            return LottoWinningNumbers(Lotto(winningNumbers), bonusNumber)
        }
    }
}
