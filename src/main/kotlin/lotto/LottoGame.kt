package lotto

import java.math.BigDecimal

private const val COUNT_OF_NUMBERS = 6
private const val MAX_NUMBER = 45
private const val PRIZE_COUNT = 3
private const val MIN_NUMBER = 1
const val PRICE_OF_LOTTO = 1000
val PRIZE_AMOUNT = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)

class LottoGame(private val count: Int) {
    private val lottoNumbers: MutableList<List<Int>> = mutableListOf()
    private val prizes: HashMap<Int, Int> = hashMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0)
    private var prizeAmount: Int = 0
    var profitRate: Double = 0.0
        private set

    fun checkPrize(prizeNumbers: List<Int>): HashMap<Int, Int> {
        lottoNumbers.forEach {
            checkMatch(it, prizeNumbers)
        }
        return prizes
    }

    fun createLotto(): List<Int> {
        val lotto = (MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS).sorted()
        lottoNumbers.add(lotto)
        return lotto
    }

    fun isEnd(): Boolean {
        return count == lottoNumbers.size
    }

    private fun checkMatch(lottoNumbers: List<Int>, prizeNumbers: List<Int>): Int {
        var count = 0
        lottoNumbers.forEach { if (prizeNumbers.contains(it)) count++ }
        if (count >= PRIZE_COUNT) {
            prizes[count] = prizes[count]!!.plus(1)
            prizeAmount += PRIZE_AMOUNT[count]
        }
        if (count > 0) {
            profitRate =
                (count * PRICE_OF_LOTTO).toBigDecimal()
                    .divide(prizeAmount.toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
                    .stripTrailingZeros().toDouble()
        }
        return count
    }
}
