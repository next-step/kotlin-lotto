package lotto.domain

class WinningMachine(private val winLotto: WinLotto) {

    fun match(lottos: List<Lotto>): Map<Rank, MutableList<Lotto>> {

        val statistic: Map<Rank, MutableList<Lotto>> = initStatistic()

        for(lotto in lottos) {
            val rank = matching(lotto, winLotto)
            statistic[rank]?.add(lotto)
        }

        return statistic
    }

    private fun initStatistic(): Map<Rank, MutableList<Lotto>> {
        return mutableMapOf(
            Rank.MISS to mutableListOf(),
            Rank.FIFTH to mutableListOf(),
            Rank.FOURTH to mutableListOf(),
            Rank.THIRD to mutableListOf(),
            Rank.SECOND to mutableListOf(),
            Rank.FIRST to mutableListOf()
        )
    }

    private fun matching(lotto: Lotto, winLotto: WinLotto): Rank {
        var count = 0
        for(num in winLotto.lotto) {
            count += containsLottoCount(lotto, num)
        }
        val isBonus = containsBonusNumber(lotto, winLotto.bonus)
        return Rank.match(count, isBonus)
    }

    private fun containsLottoCount(lotto: Lotto, num: LottoNum): Int {
        return if(lotto.contains(num)) 1 else 0
    }

    private fun containsBonusNumber(lotto: Lotto, bonus: LottoNum): Boolean {
        return lotto.contains(bonus)
    }

    companion object {
        const val WIN_LOTTO_NUM_COUNT = 3
    }
}