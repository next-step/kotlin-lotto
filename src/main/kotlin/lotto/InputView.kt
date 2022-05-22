package lotto

class InputView {

    fun payment(): String {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException()
    }

    fun winningNumber(): List<String> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lastWeekWinningNumber = readlnOrNull() ?: throw IllegalArgumentException()
        return lastWeekWinningNumber.replace(" ", "").split(',')
    }
}
