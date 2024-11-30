package lotto.domain

class WinningLotto(numbers: Set<Int>) {
    private val lotto = Lotto(numbers)

    fun calculateMatchCount(userLotto: Lotto): Int {
        return lotto.calculateMatchCount(userLotto)
    }
}
