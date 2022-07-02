package lotto.ui

import lotto.entity.LottoTicket

class InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(',').map { str -> str.trim().toInt() }
    }

    fun getBonusNumber(): Int {
        println("\n보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun getNumberOfManualTickets(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun getManualTicketNumbers(numberOfManualTicket: Int): List<LottoTicket> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val tickets = mutableListOf<LottoTicket>()
        repeat(numberOfManualTicket) {
            tickets.add(LottoTicket(readLine()!!.split(",").map { number: String -> number.toInt() }))
        }
        return tickets
    }
}
