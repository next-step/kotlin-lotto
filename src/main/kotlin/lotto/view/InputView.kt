package lotto.view

import lotto.domain.Cash
import lotto.domain.LottoUnusedTickets
import lotto.domain.LottoUsedTickets
import lotto.domain.LottoWinTicket

object InputView {

    fun readCash(): Cash {
        println("구입금액을 입력해 주세요.")
        val input = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            error("현금은 숫자여야합니다.")
        }
        return Cash(input)
    }

    fun ticketCountForManual(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun ticketsToManual(lottoUnusedTickets: LottoUnusedTickets): LottoUsedTickets {
        val inputs = (1..lottoUnusedTickets.getTicketCount()).map {
            println("수동으로 구매할 번호를 입력해 주세요.")
            readln()
        }
        return lottoUnusedTickets.toManual(inputs)
    }

    fun readWinNumber(): LottoWinTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winNumberString = readln()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberString = readln()
        return LottoWinTicket.of(winNumberString, bonusNumberString)
    }
}
