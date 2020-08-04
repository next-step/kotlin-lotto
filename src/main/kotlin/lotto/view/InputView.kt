package lotto.view

object InputView {
    fun readPayment(): Int {
        println("구입금액을 입력해주세요.")
        val payment = readLine()
        require(!payment.isNullOrBlank()) { "구입금액 입력값이 비어있습니다." }
        return payment.toInt()
    }

    fun readLuckyNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해주세요.")
        val luckyNumbers = readLine()
        require(!luckyNumbers.isNullOrBlank()) { "지난 주 당첨 번호 입력값이 비어있습니다." }
        return luckyNumbers.split(",").map { it.toInt() }
    }
}
