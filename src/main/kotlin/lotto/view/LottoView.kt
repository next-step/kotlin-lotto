package lotto.view

import lotto.view.dto.ConsoleScoreboardDto
import lotto.view.dto.ConsoleTicketsDto

interface LottoView {
    fun money(): String?
    fun winningLotto(): String?
    fun showGeneratedTickets(dto: ConsoleTicketsDto)
    fun showScoreboard(dto: ConsoleScoreboardDto)
}
