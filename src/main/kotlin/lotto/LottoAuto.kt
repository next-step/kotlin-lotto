package lotto

import kotlin.math.roundToLong

class LottoAuto {
    fun start() {
        val input = getPurchaseAmountInput()
        val (purchaseAmount, purchasedLottoCount) = purchaseLottos(input)
        purchasedLottoCountOutput(purchasedLottoCount)

        val purchasedLottos = createLottos(purchasedLottoCount)
        purchasedLottoOutput(purchasedLottoCount, purchasedLottos)

        val input2 = getWinningLottoInput()
        println("당첨 통계")
        println("--------")
        val matchedLottoNumberCounts = matchLottoNumbers(input2, purchasedLottoCount)
        matchedLottoNumberCountsOutput(matchedLottoNumberCounts)

        val rate = calculate(matchedLottoNumberCounts, purchaseAmount)
        rateOutput(rate)
    }

    fun calculate(
        matchedLottoNumberCounts: MutableMap<Int, Int>,
        purchaseAmount: Int,
    ): Double {
        val prizeAmount = calculatePrizeMoney(matchedLottoNumberCounts)
        val rate = calculateRate(prizeAmount, purchaseAmount)
        return rate
    }

    fun matchLottoNumbers(
        input2: String,
        purchasedLottoCount: Int,
    ): MutableMap<Int, Int> {
        val winningNumbers = convertToInts(input2)
        val matchedLottoNumberCounts = createMatchedLottoNumberCounts(winningNumbers, purchasedLottoCount)
        return matchedLottoNumberCounts
    }

    fun purchaseLottos(input: String): Pair<Int, Int> {
        val purchaseAmount = convertToInt(input)
        val purchasedLottoCount = countPurchasedLotto(purchaseAmount)
        return Pair(purchaseAmount, purchasedLottoCount)
    }

    fun rateOutput(rate: Double) {
        println("총 수익률은 ${rate}입니다.")
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

    fun matchedLottoNumberCountsOutput(matchedLottoNumberCounts: MutableMap<Int, Int>) {
        println("3개 일치 (5000원)- ${matchedLottoNumberCounts.getOrDefault(3, 0)}개")
        println("4개 일치 (50000원)- ${matchedLottoNumberCounts.getOrDefault(4, 0)}개")
        println("5개 일치 (150000원)- ${matchedLottoNumberCounts.getOrDefault(5, 0)}개")
        println("6개 일치 (2000000000원)- ${matchedLottoNumberCounts.getOrDefault(6, 0)}개")
    }

    private fun createMatchedLottoNumberCounts(
        winningNumbers: List<Int>,
        purchasedLottoCount: Int,
    ): MutableMap<Int, Int> {
        val matchedLottoNumberCounts = mutableMapOf<Int, Int>()
        if (winningNumbers.size != LOTTO_NUMBER_COUNT) throw RuntimeException("당첨 번호는 6개의 숫자로 이루어져야 합니다.")
        repeat(purchasedLottoCount) { idx ->
            val matchedLottoNumberCount = 2 // countMatchedLottoNumber(winningNumbers, purchasedLottos[idx])
            if (matchedLottoNumberCount >= 3) {
                val count = matchedLottoNumberCounts.getOrDefault(matchedLottoNumberCount, 0)
                matchedLottoNumberCounts[matchedLottoNumberCount] = count + 1
            }
        }
        return matchedLottoNumberCounts
    }

    private fun convertToInts(input2: String): List<Int> {
        val winningNumbers =
            input2.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map {
                    it.toIntOrNull() ?: throw NumberFormatException("숫자로 입력하지 않았습니다.")
                }
        return winningNumbers
    }

    fun getWinningLottoInput(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input2 = readlnOrNull()?.trim()
        if (input2.isNullOrEmpty()) throw RuntimeException("당첨 번호를 입력되지 않았습니다.")
        return input2
    }

    fun purchasedLottoOutput(
        purchasedLottoCount: Int,
        purchasedLottos: MutableList<List<Int>>,
    ) {
        repeat(purchasedLottoCount) { idx ->
            println(purchasedLottos[idx])
        }
    }

    fun createLottos(purchasedLottoCount: Int): MutableList<List<Int>> {
        val purchasedLottos = mutableListOf<List<Int>>()
        repeat(purchasedLottoCount) { idx ->
            val lotto = listOf<Int>(1, 2, 3, 4, 5, 6) // createLotto()
            purchasedLottos.add(lotto)
        }
        return purchasedLottos
    }

    fun purchasedLottoCountOutput(purchasedLottoCount: Int) {
        println("${purchasedLottoCount}개를 구매했습니다.")
    }

    private fun countPurchasedLotto(purchaseAmount: Int): Int {
        if (purchaseAmount <= 0) throw RuntimeException("금액은 양수입니다.")
        val purchasedLottoCount = (purchaseAmount / TICKET_PRICE)
        return purchasedLottoCount
    }

    private fun convertToInt(input: String): Int {
        val purchaseAmount = input.toIntOrNull() ?: throw RuntimeException("숫자로 입력하지 않았습니다.")
        return purchaseAmount
    }

    fun getPurchaseAmountInput(): String {
        println("구입금액을 입력해 주세요.")
        val input = readlnOrNull()?.trim()
        if (input.isNullOrEmpty()) throw RuntimeException("금액을 입력되지 않았습니다.")
        return input
    }

    private companion object {
        const val TICKET_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
    }
}
