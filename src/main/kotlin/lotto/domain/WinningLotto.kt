package lotto.domain

class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    fun calculateMatchCount(userLotto: Lotto): Int {
        return lotto.calculateMatchCount(userLotto)
    }

    fun containsBonusNumberIn(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }
}
