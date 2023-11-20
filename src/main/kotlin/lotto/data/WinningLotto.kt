package lotto.data

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {
    fun countMatchingNumbers(lotto: Lotto): Int {
        return this.lotto.selectNumbers.intersect(lotto.selectNumbers).size
    }

    fun hasBonusNumber(lotto: Lotto): Boolean {
        return lotto.selectNumbers.contains(bonusNumber)
    }
}
