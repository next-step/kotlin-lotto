package lotto

import lotto.view.InputView
import lotto.view.ResultView
import kotlin.math.roundToLong

class LottoAuto {
    private val purchaseAmountInput = InputView("구입금액을 입력해 주세요.")
    private val winningLottoInput = InputView("지난 주 당첨 번호를 입력해 주세요.")

    fun start() {
        val input = purchaseAmountInput.getIntput()
        val (purchaseAmount, purchasedLottoCount) = purchaseLottos(input)
        ResultView("${purchasedLottoCount}개를 구매했습니다.").render()

        val purchasedLottos = createLottos(purchasedLottoCount)
        repeat(purchasedLottos.size) { idx ->
            ResultView(purchasedLottos[idx].toString()).render()
        }

        val input2 = winningLottoInput.getIntput()
        ResultView("당첨 통계\n--------").render()

        val matchedLottoNumberCounts = matchLottoNumbers(input2, purchasedLottoCount)
        ResultView("3개 일치 (5000원)- ${matchedLottoNumberCounts.getOrDefault(3, 0)}개").render()
        ResultView("4개 일치 (50000원)- ${matchedLottoNumberCounts.getOrDefault(4, 0)}개").render()
        ResultView("5개 일치 (150000원)- ${matchedLottoNumberCounts.getOrDefault(5, 0)}개").render()
        ResultView("6개 일치 (2000000000원)- ${matchedLottoNumberCounts.getOrDefault(6, 0)}개").render()

        val rate = calculate(matchedLottoNumberCounts, purchaseAmount)
        ResultView("총 수익률은 ${rate}입니다.").render()
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

    fun createLottos(purchasedLottoCount: Int): MutableList<List<Int>> {
        val purchasedLottos = mutableListOf<List<Int>>()
        repeat(purchasedLottoCount) { idx ->
            val lotto = listOf<Int>(1, 2, 3, 4, 5, 6) // createLotto()
            purchasedLottos.add(lotto)
        }
        return purchasedLottos
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

    private companion object {
        const val TICKET_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
    }
}
