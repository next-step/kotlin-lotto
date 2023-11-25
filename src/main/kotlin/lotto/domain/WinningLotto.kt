package lotto.domain

class WinningLotto(val winningNumber: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumber.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
        }
    }

    fun calculatePrize(lotto: Lotto): LottoPrize {
        var matchBonus = false
        val matchedCount = getMatchingCount(lotto)
        if (lotto.contains(bonusNumber)) {
            matchBonus = true
        }
        return LottoPrize.from(matchedCount, matchBonus)
    }

    private fun getMatchingCount(lotto: Lotto): Int {
        return winningNumber.lottoNumbers.intersect(lotto.lottoNumbers.toSet()).size
    }
}
