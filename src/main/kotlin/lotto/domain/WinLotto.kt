package lotto.domain

class WinLotto(private val _lotto: Lotto, private val _bonus: LottoNum) {

    private val lotto: Lotto
        get() = this._lotto

    private val bonus: LottoNum
        get() = this._bonus

    private fun containsLottoCount(otherLotto: Lotto): Int {
        var count = 0
        for(num in otherLotto) {
            count += if(lotto.contains(num)) 1 else 0
        }
        return count
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