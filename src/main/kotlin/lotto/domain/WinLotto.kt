package lotto.domain

class WinLotto(private val lotto: Lotto, private val bonus: LottoNum) {

    private fun containsLottoCount(otherLotto: Lotto): Int {
        return otherLotto.sumOf { toOneIfContainsInLotto(it) }
    }

    private fun toOneIfContainsInLotto(num: LottoNum): Int {
        return if(lotto.contains(num)) 1 else 0
    }

    private fun containsBonusNum(lotto: Lotto): Boolean {
        return lotto.contains(bonus)
    }

    fun correspondLottoResult(lotto: Lotto): Rank {
        val lottoCount = containsLottoCount(lotto)
        val isBonus = containsBonusNum(lotto)
        return Rank.match(lottoCount, isBonus)
    }

}