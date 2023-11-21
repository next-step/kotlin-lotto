package specific.lotto.domain

class Round(val player: Player, val winningNumbers: WinningNumbers) {
    val winningResult = player.tickets
        .map { Rank.decideRank(it.countSameNumber(winningNumbers), it.hasBonusNumber(winningNumbers)) }
        .let { WinningResult(it) }

    init {
        player.receivePrize(winningResult)
    }
}
