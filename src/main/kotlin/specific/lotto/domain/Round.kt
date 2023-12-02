package specific.lotto.domain

class Round(val player: Player, val winningNumbers: WinningNumbers) {
    val winningResult = makeWinningResult()

    private fun makeWinningResult(): WinningResult {
        return player.tickets
            .let { it.manualTickets + it.autoTickets }
            .map { Rank.decideRank(it.countSameNumber(winningNumbers), it.hasBonusNumber(winningNumbers)) }
            .let(::WinningResult)
    }

    init {
        player.receivePrize(winningResult)
    }
}
