package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.strategy.Strategy
import lotto.view.ResultLotto

class Lotto(private val strategy: Strategy) {
    private val lotto = getNumbers()

    fun getLotto() = lotto

    fun getWinCount(winningNumbers: List<LottoNumber>): ResultLotto {
        var count = 0
        winningNumbers.forEach {
            if (lotto.contains(it)) count++
        }
        return ResultLotto(count)
    }

    private fun getNumbers(): List<LottoNumber> {
        val allNumber = getAllNumbers()
        val shuffledNumber = shuffle(allNumber)
        val sixNumber = getSixNumber(shuffledNumber)
        return order(sixNumber)
    }

    private fun order(numbers: List<LottoNumber>) = numbers.sortedBy { it.getNumber() }

    private fun getSixNumber(numbers: List<LottoNumber>) = numbers.subList(0, 6)

    private fun shuffle(numbers: List<LottoNumber>): List<LottoNumber> {
        return strategy.shuffle(numbers)
    }

    private fun getAllNumbers() = List(45) { i -> LottoNumber(i + 1) }

    override fun toString() = "$lotto\n"
}
