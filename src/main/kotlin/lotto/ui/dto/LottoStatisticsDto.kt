package lotto.ui.dto

import lotto.domain.LottoRanking
import java.util.SortedMap

data class LottoStatisticsDto(val statistics: SortedMap<LottoRanking, Int>, val revenue: Double) {
    constructor(statistics: Map<LottoRanking, Int>, revenue: Double) : this(statistics.toSortedMap(), revenue)
}
