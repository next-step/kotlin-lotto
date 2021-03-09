package lotto.ui

import lotto.constant.LOTTERY_TICKET_PRICE
import java.lang.IllegalArgumentException

object CashInputView {

    fun askPurchasePrice(): Int {
        println("구매금액을 입력해주세요.")
        val purchasePrice = readLine()
        return purchasePrice?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 들어왔습니다.($purchasePrice)")
    }

    fun printTicketNumber(inputPrice: Int) {
        val ticketNumber = inputPrice / LOTTERY_TICKET_PRICE
        println("${ticketNumber}개를 구매했습니다.")
    }
}