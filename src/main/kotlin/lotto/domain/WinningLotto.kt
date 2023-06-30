package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {

    fun match(newLotto: Lotto): Rank {
        val matchCount = lotto.match(newLotto)
        return Rank.of(matchCount)
    }
}
