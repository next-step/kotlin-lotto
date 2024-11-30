package lotto.domain

object LottoMatcher {
    fun matchLottoNumberCount(
        winningLotto: Lotto,
        lotto: Lotto,
    ): Int {
        return (winningLotto.numbers intersect lotto.numbers).size
    }
}
