package lotto.domain

class Lotto {
    private val numbers = List(45) { i -> LottoNumber(i + 1) }.shuffled().subList(0, 6).sortedBy { it.getNumber() }

    override fun toString() = "$numbers"

    fun getWinCount(winningNumbers: List<LottoNumber>): Int {
        var count = 0
        winningNumbers.forEach {
            if (numbers.contains(it)) count++
        }
        return count
    }
}
