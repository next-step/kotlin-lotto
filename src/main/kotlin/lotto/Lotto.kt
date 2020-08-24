package lotto

class Lotto(val lotto: List<Int>) {
    fun matchLotto(winningLotto: WinningNumbers): Int {
        return lotto.filter { winningLotto.isContained(it) }.count()
    }

    fun matchBonusBall(bonusBall: Int): Boolean {
        return lotto.contains(bonusBall)
    }

    override fun toString(): String {
        return "$lotto"
    }
}
