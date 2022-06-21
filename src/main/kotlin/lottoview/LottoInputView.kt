package lottoview

import lotto.LottoPriceRule
import lotto.LottoPurchaseHandler
import lotto.LottoWinningInfo

object LottoInputView {

    fun inputPurchaseAmount(): LottoPriceRule {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val amount = readln()

        println(INPUT_DIRECT_PURCHASE_LOTTO_COUNT_MESSAGE)
        val directPurchaseCount = readln()

        val userInputNumbers = mutableListOf<String>()
        println(INPUT_DIRECT_PURCHASE_LOTTO_NUMBERS_MESSAGE)
        repeat(directPurchaseCount.toInt()) {
            val input = readln()
            validateSplitter(input)
            userInputNumbers.add(input)
        }

        val priceInfo = LottoPurchaseHandler.calculateLottoCountByAmount(amount.toInt(), directPurchaseCount.toInt())

        priceInfo.userInputNumber = userInputNumbers

        return priceInfo
    }

    private fun validateSplitter(input: String) {
        require(input.split(",").size == 6)
    }

    fun displayPurchaseCount(autoCount: Int, directCount: Int) {
        println(INPUT_PURCHASE_NUMBER_MESSAGE.format(autoCount, directCount))
    }

    fun inputWinningNumbersAndBonusNumber(): LottoWinningInfo {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        val winningNumbers = readln()

        println(INPUT_BONUS_NUMBER_MESSAGE)
        val bonusNumber = readln()

        require(winningNumbers.contains(","))

        return LottoWinningInfo(winningNumbers, bonusNumber)
    }

    const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_PURCHASE_NUMBER_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다."
    const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    const val INPUT_DIRECT_PURCHASE_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    const val INPUT_DIRECT_PURCHASE_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
}
