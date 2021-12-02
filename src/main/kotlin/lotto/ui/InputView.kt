package lotto.ui

import lotto.domain.Ticket
import java.util.*

/**
 *
 * @author Leo
 */
class InputView {

    fun getAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readLine()!!
    }

    fun showTicketCount(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.numbers)
        }
        println("")
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(",").map { it.toInt() }
    }

}
