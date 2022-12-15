package lotto.infra.io

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.ticket.LottoTicket

class LottoInputReader {

    fun readLottoCost(): LottoCost {
        return LottoCost(readLine().toInt())
    }

    fun readLottoBonusNumber(): LottoNumber {
        return LottoNumber(readLine().toInt())
    }

    fun readLottoTicket(): LottoTicket {
        return LottoTicket(readLine().split(",").map { LottoNumber(it.trim().toInt()) })
    }

    fun readCustomLottoTicketCount(): Int {
        val count =  readln().trim().toInt()

        require(count >= 0) {
            "Custom Lotto Ticket Count should be greater or equal than 0 [$count]"
        }

        return count
    }

    fun readCustomLottoTicketList(count: Int): List<LottoTicket> {
        require(count >= 0) {
            "Custom Lotto Ticket Count should be greater or equal than 0 [$count]"
        }

        return (0 until count).map { readLottoTicket() }
    }

    private fun readLine(): String = readln().trim()
}
