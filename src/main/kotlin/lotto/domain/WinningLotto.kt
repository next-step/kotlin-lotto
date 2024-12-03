package lotto.domain

class WinningLotto(private val lotto: Lotto) {
    fun calculateMatchCount(userLotto: Lotto): Int {
        return lotto.calculateMatchCount(userLotto)
    }
}
