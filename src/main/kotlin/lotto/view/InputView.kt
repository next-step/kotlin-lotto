package lotto.view

object InputView {

    fun getAmount(): Int {
        println("구매 금액을 입력해주세요.")
        return read()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return read()
    }

    private fun read(): Int {
        return readLine()?.toInt() ?: throw NumberFormatException("숫자를 입력해주세요.")
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readLine()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException()
    }
}
