package lotto.view

private const val NUMBER_DEMILITER = ","

object InputView {

    fun getUserInputMoney(): Int {
        println("로또 구입금액을 입력해주세요.")
        var money = readLine()
        while (money.isNullOrBlank()) {
            money = readLine()
        }

        return money.toInt()
    }

    fun getInputLuckyNumber(): List<Int> {
        println("지난 주 당첨번호를 입력해주세요.")
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(NUMBER_DEMILITER).map { it.toInt() }
    }
}
