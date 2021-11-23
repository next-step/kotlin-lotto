package lotto.view

import lotto.view.dto.ConsoleScoreboardDto
import lotto.view.dto.ConsoleTicketsDto

object SimpleLottoView : LottoView {
    override fun money(): String? = withInput {
        println("구입금액을 입력해 주세요.")
    }

    override fun winningLotto(): String? = withInput {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    override fun showGeneratedTickets(dto: ConsoleTicketsDto) {
        println("${dto.count}개를 구매했습니다.")
        println("${dto.lottos}${System.lineSeparator()}")
    }

    override fun showScoreboard(dto: ConsoleScoreboardDto) {
        println(dto.status
            .joinToString(separator = System.lineSeparator()) { it })
        println("총 수익률은 %.2f입니다.".format(dto.yield))
    }

    private fun withInput(showMessage: () -> Unit): String? {
        showMessage()
        return readLine()
    }
}
