package lotto.view

object InputView {

    fun getAmount(): Int {
        println("구매 금액을 입력해주세요.")
        return readLine()?.toInt() ?: throw NumberFormatException("숫자를 입력해주세요.")
    }

    fun getWinningNumbers(): List<Int> {
        return readLine()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException()
    }

}
