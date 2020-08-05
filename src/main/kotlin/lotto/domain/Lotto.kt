package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.domain.value.WinLotto.Companion.plusCount
import lotto.strategy.Strategy

data class Lotto(private val strategy: Strategy) {
    private val lotto = getNumbers()

    fun getLotto() = lotto

    fun winCount(winningNumbers: List<LottoNumber>) {
        var count = ZERO
        winningNumbers.forEach {
            if (lotto.contains(it)) {
                count++
            }
        }
        plusCount(count)
    }

    private fun getNumbers(): List<LottoNumber> {
        val allNumber = getAllNumbers()
        val shuffledNumber = shuffle(allNumber)
        val sixNumber = getSixNumber(shuffledNumber)
        return order(sixNumber)
    }

    private fun order(numbers: List<LottoNumber>) = numbers.sortedBy { it.getNumber() }

    private fun getSixNumber(numbers: List<LottoNumber>) = numbers.subList(SUBLIST_START, SUBLIST_END)

    private fun shuffle(numbers: List<LottoNumber>) = strategy.shuffle(numbers)

    private fun getAllNumbers() = List(MAX_NUBER) { i -> LottoNumber(i + 1) }

    override fun toString() = "$lotto\n"

    companion object {
        private const val ZERO = 0
        private const val SUBLIST_START = 0
        private const val SUBLIST_END = 6
        private const val MAX_NUBER = 45
    }
}
