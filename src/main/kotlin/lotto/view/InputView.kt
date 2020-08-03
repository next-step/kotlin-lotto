package lotto.view

object InputView {
    fun readPayment(): Int {
        println("구입금액을 입력해주세요.")
        val money = readLine()
        require(!money.isNullOrBlank()) { "구입금액 입력값이 비어있습니다." }
        return money.toInt()
    }

    fun readLuckyNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해주세요.")
        val numbers = readLine()
        require(!numbers.isNullOrBlank()) { "지난 주 당첨 번호 입력값이 비어있습니다." }
        return numbers.split(",").map { it.toInt() }
    }
}
