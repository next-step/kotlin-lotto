package lotto

class Lotto {
    private val lotto = getRandomNumbers()

    fun matchLotto(winningLotto: WinningNumbers): Int {
        return lotto.filter { winningLotto.isContained(it) }.count()
    }

    fun matchBonusBall(bonusBall: Int): Boolean {
        return lotto.contains(bonusBall)
    }

    private fun getRandomNumbers(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).map { it }.shuffled().subList(FIRST_INDEX, LAST_INDEX).sorted()
    }

    override fun toString(): String {
        return "$lotto"
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val FIRST_INDEX = 0
        const val LAST_INDEX = 6
    }
}
