package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val input = readlnOrNull()
        val parsedInput = input?.toIntOrNull()
        require(parsedInput != null) { "숫자만 입력 가능합니다." }
        return parsedInput
    }

    fun getLastWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }
}
