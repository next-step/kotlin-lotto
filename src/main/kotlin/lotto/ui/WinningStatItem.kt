package lotto.ui

import lotto.LottoRank

class WinningStatItem(private val rank: LottoRank, private val count: Int) : UI {
    override fun draw() {
        println("${this.rank.matchCount}개 일치 (${this.rank.money}원)- ${this.count}개")
    }
}
