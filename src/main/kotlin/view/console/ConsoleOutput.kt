package view.console

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.result.LottoRank
import lotto.domain.result.LottoResult
import view.OutputView

class ConsoleOutput : OutputView {
    override fun printStringAdderInputMessage() {
        println("덧셈할 숫자를 쉼표(,)와 콜론(:)으로 구분해서 입력해주세요.")
    }

    override fun printStringAdderResultMessage(result: Int) {
        println("결과는 ${result}입니다.")
    }

    override fun printPurchaseAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    override fun printLottoTickets(tickets: LottoTickets) {
        println("${tickets.tickets.size}개를 구매했습니다.")
        tickets.tickets.forEach { printLottoTicket(it) }
    }

    private fun printLottoTicket(ticket: LottoTicket) {
        println("[${ticket.numbers.map { it.number }.joinToString(", ")}]")
    }

    override fun printInputWinningNumbersMessage() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    override fun printLottoResult(result: LottoResult) {
        val builder = StringBuilder()
            .append("당첨 통계\n")
            .append("---------\n")
        appendLottoDetail(result, builder)
        appendEarning(result, builder)
        println(builder)
    }

    override fun printInputBonusNumberMessage() {
        println("보너스 볼을 입력해주세요.")
    }

    private fun appendLottoDetail(result: LottoResult, builder: StringBuilder) {
        LottoRank.values().reversed().drop(1)
            .forEach lit@{
                if (it == LottoRank.SECOND) {
                    builder.append("${it.matchCount}개 일치, 보너스 볼 일치 (${it.prize}원) - ${result.result[it]}개\n")
                    return@lit
                }
                builder.append("${it.matchCount}개 일치 (${it.prize}원) - ${result.result[it]}개\n")
            }
    }

    private fun appendEarning(result: LottoResult, builder: StringBuilder) {
        builder.append("총 수익률은 ${result.earning}입니다. (1이 기준)")
    }
}
