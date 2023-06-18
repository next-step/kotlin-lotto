package lotto

import lotto.vo.Money

data class GameResult(
    val prizes: List<Pair<WinningPrize, Int>>,
    val paidPrice: Money,
)
