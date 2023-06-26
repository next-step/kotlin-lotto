package lotto.domain

class WinningLotto(val lotto: Lotto, val bonus: LottoNumber) {

    fun rank(compare: Lotto): LottoRank {
        val matchingNumberCount = compare.lottoNumbers.count { lotto.contains(it) }
        val matchingBonus = compare.contains(bonus)
        return LottoRank.valueOf(matchingNumberCount, matchingBonus)
    }
}
