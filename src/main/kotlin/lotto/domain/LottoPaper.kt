package lotto.domain

internal data class LottoPaper(val lottos: List<Lotto>) {

    fun doStatistics(money: Money, winLotto: Lotto, bonusNum: LottoNum): LottoStatistics {
        val ranks = this.lottos.map {
            val matchedNums = it.findMatchNums(winLotto)
            Rank.find(matchedNums.size, it.contain(bonusNum))
        }

        return LottoStatistics(money, ranks)
    }
}
