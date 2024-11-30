package lotto

import lotto.util.StringParser
import kotlin.math.roundToLong

class LottoAutoController {
    fun getPurchaseAmount(input: String): Int = StringParser.convertToInt(input)

    fun countPurchasedLotto(purchaseAmount: Int): Int {
        if (purchaseAmount <= 0) throw RuntimeException("금액은 양수입니다.")
        val purchasedLottoCount = (purchaseAmount / TICKET_PRICE)
        return purchasedLottoCount
    }

    private companion object {
        const val TICKET_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
    }

    fun createLottos(purchasedLottoCount: Int): MutableList<List<Int>> {
        val purchasedLottos = mutableListOf<List<Int>>()
        repeat(purchasedLottoCount) { _ ->
            val lotto = listOf<Int>(1, 2, 3, 4, 5, 6) // createLotto()
            purchasedLottos.add(lotto)
        }
        return purchasedLottos
    }

    fun matchLottoNumbers(
        input2: String,
        purchasedLottoCount: Int,
    ): MutableMap<Int, Int> {
        val winningNumbers = StringParser.convertToInts(input2)
        val matchedLottoNumberCounts = createMatchedLottoNumberCounts(winningNumbers, purchasedLottoCount)
        return matchedLottoNumberCounts
    }

    private fun createMatchedLottoNumberCounts(
        winningNumbers: List<Int>,
        purchasedLottoCount: Int,
    ): MutableMap<Int, Int> {
        val matchedLottoNumberCounts = mutableMapOf<Int, Int>()
        if (winningNumbers.size != LOTTO_NUMBER_COUNT) throw RuntimeException("당첨 번호는 6개의 숫자로 이루어져야 합니다.")
        repeat(purchasedLottoCount) { _ ->
            val matchedLottoNumberCount = 2 // countMatchedLottoNumber(winningNumbers, purchasedLottos[idx])
            if (matchedLottoNumberCount >= 3) {
                val count = matchedLottoNumberCounts.getOrDefault(matchedLottoNumberCount, 0)
                matchedLottoNumberCounts[matchedLottoNumberCount] = count + 1
            }
        }
        return matchedLottoNumberCounts
    }

    fun calculate(
        matchedLottoNumberCounts: MutableMap<Int, Int>,
        purchaseAmount: Int,
    ): Double {
        val prizeAmount = calculatePrizeMoney(matchedLottoNumberCounts)
        val rate = calculateRate(prizeAmount, purchaseAmount)
        return rate
    }

    private fun calculateRate(
        prizeAmount: Int,
        purchaseAmount: Int,
    ): Double {
        val rate = (prizeAmount.toDouble() / purchaseAmount)
        return (rate * 100).roundToLong() / 100.0
    }

    private fun calculatePrizeMoney(matchedLottoNumberCounts: MutableMap<Int, Int>): Int {
        val prizeAmount =
            (5000 * matchedLottoNumberCounts.getOrDefault(3, 0)) +
                (50000 * matchedLottoNumberCounts.getOrDefault(4, 0)) +
                (150000 * matchedLottoNumberCounts.getOrDefault(5, 0)) +
                (2000000000 * matchedLottoNumberCounts.getOrDefault(6, 0))
        return prizeAmount
    }
}
