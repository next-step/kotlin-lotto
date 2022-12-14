package lotto.model

data class WinningStatistics(var ranks: MutableMap<Rank, Int>, var rate: Double)
