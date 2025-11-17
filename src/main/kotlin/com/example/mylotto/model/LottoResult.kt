package com.example.mylotto.model

import com.example.mylotto.enum.Rank

class LottoResult(
    ranks: List<Rank>,
) {
    private val rankCountMap: Map<Rank, Int> = ranks.groupingBy { it }.eachCount()
}
