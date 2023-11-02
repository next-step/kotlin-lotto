package lotto.view

object InputView {

    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readln()
        require(price.isNotBlank()) { BLANK_ERROR_MESSAGE }
        return try {
            price.toInt()
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputPrice()
        }
    }
    fun inputWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotto = readln()
        require(winningLotto.isNotBlank()) { BLANK_ERROR_MESSAGE }
        return try {
            winningLotto.split(DELIMITER).map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            println(NUMBER_ERROR_MESSAGE)
            inputWinningLotto()
        }
    }

    private const val DELIMITER = ","
    private const val BLANK_ERROR_MESSAGE = "입력값이 없습니다."
    private const val NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요."
}
