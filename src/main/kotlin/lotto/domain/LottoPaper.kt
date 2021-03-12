package lotto.domain

internal data class LottoPaper(val lottos: List<Lotto>) {
    fun doStatistics(money: Money, winLotto: WinLotto): LottoStatistics {
        val ranks = this.lottos.map {
            val matchedNums = winLotto.findMatchNums(it)
            Rank.find(matchedNums.size, winLotto.matchBonusNum(it))
        }

        return LottoStatistics(money, ranks)
    }
}
