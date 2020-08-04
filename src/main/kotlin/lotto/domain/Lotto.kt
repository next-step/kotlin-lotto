package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.domain.value.WinLotto.Companion.plusCount
import lotto.strategy.Strategy

data class Lotto(private val strategy: Strategy) {
    private val lotto = getNumbers()

    fun getLotto() = lotto

    fun winCount(winningNumbers: List<LottoNumber>) {
        var count = 0
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

    private fun getSixNumber(numbers: List<LottoNumber>) = numbers.subList(0, 6)

    private fun shuffle(numbers: List<LottoNumber>) = strategy.shuffle(numbers)

    private fun getAllNumbers() = List(45) { i -> LottoNumber(i + 1) }

    override fun toString() = "$lotto\n"
}
