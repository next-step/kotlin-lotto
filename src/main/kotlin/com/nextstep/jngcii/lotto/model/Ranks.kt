package com.nextstep.jngcii.lotto.model

class Ranks(private val ranks: List<Rank>) {
    val sumOfPrice = ranks.sumOf { it.price }.toDouble()
    fun countOf(rank: Rank) = ranks.count { it == rank }
}
