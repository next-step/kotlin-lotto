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
        return NUMBER_RANGE.shuffled().take(LOTTO_COUNT).sorted()
    }

    override fun toString(): String {
        return "$lotto"
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        const val LOTTO_COUNT = 6
        val NUMBER_RANGE = (MIN_NUMBER..MAX_NUMBER)
    }
}
