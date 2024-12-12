package lotto.view

import lotto.domain.LottoResult.Companion.TICKET_PRICE

class InputView {
    fun inputUser(): Int {
        println("구입금액을 입력해 주세요.")
        val totalAmount = readln().toIntOrNull()
        val count = (totalAmount ?: 0) / TICKET_PRICE
        return count
    }

    fun inputWinNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winString = readln().replace(" ", "")
        val numbers = winString.split(",")
        return numbers.map { it.toIntOrNull() ?: -1 }.toList()
    }
}
