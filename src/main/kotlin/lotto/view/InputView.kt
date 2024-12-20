package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTicket.Companion.TICKET_PRICE

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

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readInt()
        return bonusNumber
    }

    fun inputManualTickets(): List<LottoTicket> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val lottoTickets =
            List(count) {
                val winString = readln().replace(" ", "")
                val numbers = winString.split(",")
                LottoTicket(numbers.map { LottoNumber(it.toInt()) })
            }

        return lottoTickets
    }

    private fun readInt(): Int {
        return readln().toIntOrNull() ?: throw IllegalArgumentException("숫자로 입력해 주세요")
    }
}
