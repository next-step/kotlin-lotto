package lotto

import lotto.service.LottoService
import lotto.service.SimpleLottoService
import lotto.view.dto.ConsoleScoreboardDto
import lotto.view.dto.ConsoleTicketsDto
import lotto.view.LottoView
import lotto.view.SimpleLottoView

fun main() {
    LottoApplication(SimpleLottoService(), SimpleLottoView).run()
}

class LottoApplication(
    private val lottoService: LottoService,
    private val lottoView: LottoView,
) {
    fun run() {
        val money: String? = lottoView.money()
        val lottos = lottoService.randomLottos(money)
        lottoView.showGeneratedTickets(ConsoleTicketsDto(lottos))

        val winningLotto: String? = lottoView.winningLotto()
        val scoreboard = lottoService.scoreboard(lottos, winningLotto)
        lottoView.showScoreboard(ConsoleScoreboardDto(scoreboard, lottos))
    }
}
