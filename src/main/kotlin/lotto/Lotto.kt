package lotto

data class Lotto(
    val numbers: Set<Int>,
) {
    fun match(winningLotto: Lotto, bonus: Int): Pair<Int, Boolean> {
        val count = numbers.intersect(winningLotto.numbers).count()
        val hasBonus = if (count == 5) hasMatchBonusBall(bonus) else false
        return count to hasBonus
    }

    private fun hasMatchBonusBall(bonus: Int): Boolean {
        return numbers.contains(bonus)
    }

    companion object {
        fun getAutoNumbers(): Lotto {
            val numbers = (LOTTO_MIN_VALUE..LOTTO_MAX_VALUE).toList().shuffled().take(LOTTO_COUNT).sorted().toSet()
            return Lotto(numbers)
        }

        private const val LOTTO_MIN_VALUE = 1
        private const val LOTTO_MAX_VALUE = 45
        private const val LOTTO_COUNT = 6
    }
}
