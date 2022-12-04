package lotto.view

import lotto.common.LottoTicketPolicy

object InputView {
    fun getNumberOfPurchases(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readlnOrNull()
        require(!amount.isNullOrEmpty()) { "금액을 입력해주세요." }

        println(amount)

        val tickets = amount.toInt() / LottoTicketPolicy.PRICE
        println("$tickets 개를 구매했습니다.")

        return tickets
    }

    fun getWinningNumber(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readlnOrNull()
        require(!winningNumber.isNullOrEmpty()) { "당첨 번호를 입력해주세요." }

        val numbers = winningNumber.split(", ").map { it.toInt() }.toSet()
        require(numbers.size == 6) {" 중복없는 6개의 숫자를 입력해주세요."}

        return numbers
    }
}
