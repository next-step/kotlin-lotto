package lotto.domain

class WinningMachine(private val winLotto: WinLotto) {

    fun match(lottos: List<Lotto>): Statistics {

        val statistic = Statistics()

        for(lotto in lottos) {
            val rank = matching(lotto, winLotto)
            statistic.add(rank, lotto)
//            statistic.from(rank)?.add(lotto)
        }

        return statistic
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

}