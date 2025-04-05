package lotto

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(!lotto.contains(bonusNumber)) { ERROR_BONUS_NUMBER }
    }

    fun containBonusNumber(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }

    fun matchCount(other: Lotto): Int {
        return other.lottoNumbers.count { lotto.contains(it) }
    }

    companion object {
        private const val ERROR_BONUS_NUMBER = "Bonus number can not be included in Lotto numbers"
    }
}
