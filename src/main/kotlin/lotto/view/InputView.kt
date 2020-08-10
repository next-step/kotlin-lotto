package lotto.view

object InputView {

    private const val NUMBER_DELIMETER = ","

    fun getUserInputMoney(): Int {
        println("로또 구입금액을 입력해주세요.")
        var money = readLine()
        while (money.isNullOrBlank()) {
            money = readLine()
        }
        return money.toIntOrNull() ?: 0
    }

    fun getInputLuckyNumber(): List<Int> {
        println("지난 주 당첨번호를 입력해주세요.")
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(NUMBER_DELIMETER).map { it.toInt() }
    }
}
