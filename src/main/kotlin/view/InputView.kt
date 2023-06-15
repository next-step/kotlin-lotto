package view

class InputView(private val inputReader: InputReader) {

    fun enterTheMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        require(money.toIntOrNull() != null) { "구입 금액이 올바르지 않습니다 : $money" }
        println(money)
        return money.toInt()
    }
}
