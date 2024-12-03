package lotto.view

object InputView {
    private const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val MESSAGE_INPUT_WINNER_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private const val MESSAGE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun inputPurchaseAmount(): Int {
        println(MESSAGE_INPUT_PURCHASE_AMOUNT)
        return requireNotNull(readln().toIntOrNull())
    }

    fun inputWinnerLottoNumbers(): List<Int> {
        println(MESSAGE_INPUT_WINNER_LOTTO_NUMBERS)
        return readln().split(",").map { it.trim().toInt() }
    }

    fun inputBonusNumber(): Int {
        println(MESSAGE_INPUT_BONUS_NUMBER)
        return requireNotNull(readln().toIntOrNull())
    }
}
