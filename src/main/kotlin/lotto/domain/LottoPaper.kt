package lotto.domain

internal data class LottoPaper(val lottos: List<Lotto>) {

    val autoLottoCount: Int
        get() = this.lottos.filter { it.auto }.count()

    val selfLottoCount: Int
        get() = this.lottos.filter { !it.auto }.count()

    fun doStatistics(money: Money, winLotto: Lotto, bonusNum: LottoNum): LottoStatistics {
        val ranks = this.lottos.map {
            val matchedNums = it.findMatchNums(winLotto)
            Rank.find(matchedNums.size, it.contain(bonusNum))
        }

        return LottoStatistics(money, ranks)
    }
}
