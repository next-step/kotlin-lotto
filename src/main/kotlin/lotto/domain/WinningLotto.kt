package lotto.domain

class WinningLotto(
    val lotto: Lotto
) {

    fun match(newLotto: Lotto): Rank {
        val matchCount = this.lotto.lottoNumbers.count(newLotto.lottoNumbers::contains)
        return Rank.of(matchCount)
    }
}
