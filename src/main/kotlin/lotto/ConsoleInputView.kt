package lotto

class ConsoleInputView : InputView {
    override fun requestPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price =
            readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다.")

        return price.toInt()
    }

    override fun requestWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers =
            readlnOrNull() ?: throw IllegalArgumentException("입력값이 없습니다.")

        return numbers.split(DELIMITER)
            .map { it.trim().toInt() }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
