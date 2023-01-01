package com.nextstep.lotto.domain

class Lottos(val lottos: List<Lotto>) {

    fun match(winningLotto: WinningLotto): LottoStat {
        val matchCounts = lottos.map { winningLotto.match(it) }
        return LottoStat(matchCounts)
    }

    fun getCount(): Int = lottos.size
}
