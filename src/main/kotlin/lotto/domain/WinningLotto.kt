package lotto.domain

data class WinningLotto(val lotto: Lotto, val bonus: LottoNumber) {
    fun checkMatch(lotto: Lotto): Match {
        return Match.valueOf(lotto.countSameNumbers(this.lotto), lotto.contains(bonus))
    }
}
