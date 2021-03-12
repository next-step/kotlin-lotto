package lotto.domain

internal class WinLotto(val lotto: Lotto, val bonusNum: LottoNum) {

    fun findMatchNums(lotto: Lotto): List<LottoNum> {
        return this.lotto.findMatchNums(lotto)
    }

    fun matchBonusNum(lotto: Lotto): Boolean {
        return lotto.matchNum(this.bonusNum)
    }
}
