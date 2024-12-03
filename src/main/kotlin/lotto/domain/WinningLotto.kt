package lotto.domain

class WinningLotto(private val lotto: Lotto, bonusNumber: LottoNumber) {
    fun calculateMatchCount(userLotto: Lotto): Int {
        return lotto.calculateMatchCount(userLotto)
    }
}
