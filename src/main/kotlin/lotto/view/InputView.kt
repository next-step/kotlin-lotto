package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoTickets

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoNumbers(count: Int): LottoTickets {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val tickets = mutableListOf<Lotto>()
        repeat(count) {
            val numbers = readln().split(",").map { it.trim().toInt() }
            tickets.add(Lotto.of(numbers))
        }
        return LottoTickets(tickets)
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { it.trim().toInt() }
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
