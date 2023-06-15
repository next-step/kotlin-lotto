package view

class InputView(private val inputReader: InputReader) {

    fun enterTheMoney() {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        println(money)
    }
}
