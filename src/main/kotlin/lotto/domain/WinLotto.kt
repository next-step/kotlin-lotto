package lotto.domain

class WinLotto(private val lotto: Lotto, private val bonus: LottoNum) {

    fun correspondLottoResult(lotto: Lotto): Rank {
        val lottoCount = containsLottoCount(lotto)
        val isBonus = containsBonusNum(lotto)
        return Rank.match(lottoCount, isBonus)
    }

    private fun containsLottoCount(otherLotto: Lotto): Int {
        return otherLotto.sumOf { toOneIfContainsInLotto(it) }
    }

    private fun containsBonusNum(lotto: Lotto): Boolean {
        return lotto.contains(bonus)
    }

    private fun toOneIfContainsInLotto(num: LottoNum): Int {
        return if(lotto.contains(num)) 1 else 0
    }

}