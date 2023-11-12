package lotto.view

object InputView {
    private const val ONLY_ALLOW_INTEGER_MESSAGE = "숫자만 입력 가능합니다."

    fun getPurchaseAmount(): Int {
        return receiveOneInteger("구입 금액을 입력해 주세요.")
    }

    fun getLastWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusBall(): Int {
        return receiveOneInteger("보너스 볼을 입력해 주세요.")
    }

    private fun receiveOneInteger(message: String): Int {
        println(message)
        val input = readlnOrNull()
        val parsedInput = input?.toIntOrNull()
        require(parsedInput != null) { ONLY_ALLOW_INTEGER_MESSAGE }
        return parsedInput
    }
}
