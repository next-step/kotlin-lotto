package com.nextstep.jngcii.lotto.model

class Lottos(private val lottos: List<Lotto>) {
    fun getResult(lastWeekLotto: Lotto) = lottos.mapNotNull {
        val sameCount = it.getSameCount(lastWeekLotto)
        Rank.of(sameCount)
    }.let { Ranks(it) }
}
