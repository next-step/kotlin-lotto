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

    override fun printPurchasedLotto(lottoTickets: LottoTickets) {
        lottoTickets.lottoTicketList.forEach { ticket ->
            println(
                ticket.lottoNumberList.map { number ->
                    number.value
                }
            )
        }
        println("${lottoTickets.lottoTicketList.size} 개를 구매했습니다.")
    }
}