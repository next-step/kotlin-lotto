package lotto.view

object InputView {
    fun getNumberOfPurchases(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readlnOrNull()
        require(!amount.isNullOrEmpty()) { "금액을 입력해주세요." }

        println(amount)

        val tickets = amount.toInt() / 1000
        println("$tickets 개를 구매했습니다.")

        return tickets
    }

    fun getWinningNumber(): List<Int> {
        val winningNumber = readlnOrNull()
        require(!winningNumber.isNullOrEmpty()) { "당첨 번호를 입력해주세요." }
        println("지난 주 당첨 번호를 입력해 주세요.")

        return  winningNumber.split(", ").toList().map { it.toInt() }
    }
}
