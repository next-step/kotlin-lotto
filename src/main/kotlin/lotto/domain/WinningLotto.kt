package lotto.domain

class WinningLotto(
    val lotto: Lotto
) {

    fun match(newLotto: Lotto): Rank {
        val matchCount = lotto.match(newLotto)
        return Rank.of(matchCount)
    }
}
