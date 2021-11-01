package lotto.view

class InputView {

    companion object {
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val DELIMITERS = ", "

        fun inputPrice(): Int? {
            println(INPUT_PRICE_MESSAGE)
            return readLine()!!.toIntOrNull()
        }

        fun inputWinningNumber(): List<String> {
            println(INPUT_WINNING_NUMBER_MESSAGE)
            return readLine()?.split(DELIMITERS) ?: emptyList()
        }

        fun inputBonusNumber(): Int? {
            println(INPUT_BONUS_NUMBER_MESSAGE)
            return readLine()!!.toIntOrNull()
        }
    }
}
