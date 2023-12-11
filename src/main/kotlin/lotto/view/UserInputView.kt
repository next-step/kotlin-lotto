package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningNumber
class UserInputView : InputView {
    override fun getBudget(): Int = println("구입 금액을 입력하세요").run {
        readln().trim().toInt()
    }

    override fun getWinningNumber(): WinningNumber {
        val lottoNumberList = println("당첨번호는 무엇인가요?").run {
            readln().trim().split(",").map { it.toInt() }.map { LottoNumber(it) }
        }

        val bonusBall = println("보너스 볼을 입력해 주세요.").run {
            LottoNumber(readln().trim().toInt())
        }

        return WinningNumber(
            LottoTicket(lottoNumberList),
            bonusBall,
        )
    }

    override fun printPurchasedLotto(autoLottoTickets: LottoTickets, manualLottoTickets: LottoTickets) {
        println("수동으로 ${manualLottoTickets.lottoTicketList.size}, 자동으로 ${autoLottoTickets.lottoTicketList.size} 개를 구매했습니다.")
        manualLottoTickets.print()
        autoLottoTickets.print()
    }

    override fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().trim().toInt()
    }

    override fun getManualNumbers(manualLottoCount: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val lottoTicketNumbers = mutableListOf<List<Int>>()

        repeat(manualLottoCount) {
            val lottoTicket = readln().trim().split(",").map { it.toInt() }
            lottoTicketNumbers.add(lottoTicket)
        }
        return lottoTicketNumbers
    }

    private fun LottoTickets.print() {
        lottoTicketList.forEach { ticket ->
            println(
                ticket.lottoNumberList.map { number ->
                    number.value
                }
            )
        }
    }
}
