package lotto.ui

object InputView  {

    private const val INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val DELIMITER = ","

    fun read(): List<Int> {
        println(INPUT_MESSAGE)
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }
}