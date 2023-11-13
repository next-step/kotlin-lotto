package me.parker.nextstep.kotlinlotto.domain

data class LottoResult(val matchCount: Map<LottoRank, Int>, val profitRate: Double)
