package lotto.model

data class WinningStatistics(val ranks: Map<Rank, List<RankCounter>>, var rate: Double)
