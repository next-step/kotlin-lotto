package lotto.domain

import lotto.domain.value.LottoNumber

class Lotto {
    private val numbers = List(45) { i -> LottoNumber(i + 1) }.shuffled().subList(0, 6).sortedBy { it.getNumber() }

    override fun toString() = "$numbers\n"

    fun getWinCount(winningNumbers: List<LottoNumber>): Int {
        var count = 0
        winningNumbers.forEach {
            if (numbers.contains(it)) count++
        }
        return count
    }
}
