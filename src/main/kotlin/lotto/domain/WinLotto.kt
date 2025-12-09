package lotto.domain

class WinLotto(val winLotto: Lotto) {
    fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }
}
