package lotto.ui
import lotto.domain.maker.LotteryTicketMaker
import java.lang.IllegalArgumentException

object CashInputView {

    fun askPurchasePrice(): Int {
        println("구매금액을 입력해주세요.")
        val purchasePrice = readLine()
        return purchasePrice?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 들어왔습니다.($purchasePrice)")
    }

    fun printTicketNumber(ticketNumber: Int) {
        println("${ticketNumber}개를 구매했습니다.")
    }
}
