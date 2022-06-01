package com.nextstep.jngcii.lotto.model

class Lottos(private val lottos: List<Lotto>) {
    fun getResult(lastWeekLotto: Lotto, bonusNumber: BonusNumber) = lottos.mapNotNull {
        val sameCount = it.getSameCount(lastWeekLotto)
        val bonusMatch = it.contains(bonusNumber)
        Rank.of(sameCount, bonusMatch)
    }.let { Ranks(it) }
}
