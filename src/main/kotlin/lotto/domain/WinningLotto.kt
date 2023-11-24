package lotto.domain

class WinningLotto(val winningNumber: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumber.lottoNumbers.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
        }
    }

    fun calculatePrize(lotto: Lotto): LottoPrize {
        val matchedCount = getMatchingCount(lotto)
        return LottoPrize.from(matchedCount)
    }

    private fun getMatchingCount(lotto: Lotto): Int {
        return winningNumber.lottoNumbers.intersect(lotto.lottoNumbers.toSet()).size
    }
}
