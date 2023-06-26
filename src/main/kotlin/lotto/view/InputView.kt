package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPurchaseRequest

class InputView {

    fun createRequest(): LottoPurchaseRequest {
        val inputMoney = inputPurchaseAmount()
        val purchaseAmount = getPurchasableNum(inputMoney)
        var manualAmount = inputManualAmount()

        while (manualAmount > purchaseAmount) {
            println("구입금액은 0보다 크고 100만보다 작거나 같아야 합니다. 다시 입력해주세요.")
            manualAmount = inputManualAmount()
        }
        val manualNumbers = if (manualAmount != 0) inputManualNumbers(manualAmount) else emptyList()

        val autoAmount = purchaseAmount - manualAmount

        return LottoPurchaseRequest(autoAmount, manualNumbers)
    }

    private fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        var inputAmount = readNumber()
        while (!(inputAmount in PURCHASABLE_RANGE)) {
            println("구입금액은 0보다 크고 100만보다 작거나 같아야 합니다. 다시 입력해주세요.")
            inputAmount = readNumber()
        }
        return inputAmount
    }

    private fun inputManualAmount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readNumber()
    }

    private fun inputManualNumbers(cnt: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(cnt) { inputLottoNumbers() }
    }

    fun inputWinningNums(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return inputLottoNumbers()
    }

    fun inputBunusNum(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readNumber()
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }

    private fun inputLottoNumbers(): List<Int> {
        val input = readlnOrNull() ?: return emptyList()
        val numbers = input.split(",", " ").map { it.trim().toInt() }
        return numbers.take(Lotto.COUNT_OF_LOTTO_NUMBER)
    }

    private fun getPurchasableNum(inputAmount: Int): Int {
        return inputAmount / Lotto.PRICE
    }

    companion object {
        private val PURCHASABLE_RANGE = 1..1000000
    }
}
