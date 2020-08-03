package lotto

import java.math.BigDecimal

private const val COUNT_OF_NUMBERS = 6
private const val MAX_NUMBER = 45
private const val MIN_NUMBER = 1
private const val PRICE_OF_LOTTO = 1000
private val PRIZE_AMOUNT = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)

class Lotto(amount: Int) {
    private val lottoNumbers: MutableList<List<Int>> = mutableListOf()
    private val prizes: HashMap<Int, Int> = hashMapOf()
    private var prizeAmount: Int = 0

    init {
        for (i in 1..amount / PRICE_OF_LOTTO) {
            lottoNumbers.add(getNumbers())
        }
    }

    fun execute(prizeNumbers: List<Int>) {
        lottoNumbers
            .forEach {
                val number = getMatchCount(it, prizeNumbers)
                prizes[number] = PRIZE_AMOUNT[number]
                prizeAmount += PRIZE_AMOUNT[number]
            }
    }

    private fun getNumbers(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS).sorted()
    }

    private fun getMatchCount(lottoNumbers: List<Int>, prizeNumbers: List<Int>): Int {
        var count: Int = 0
        lottoNumbers.forEach { if (prizeNumbers.contains(it)) count++ }
        return count
    }

    private fun getPrizeAmount(matchCount: Int): Int {
        try {
            return PRIZE_AMOUNT[matchCount]
        } catch (e: IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException("숫자를 확인해 주세요.")
        }
    }

    private fun getProfitRate(): String {
        return prizeAmount.toBigDecimal().divide(PRICE_OF_LOTTO.toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toPlainString()
    }
}
