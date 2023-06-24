package lotto.domain

class WinningLotto(val lotto: Lotto) {

    fun rank(compare: Lotto): LottoRank {
        val matchingNumberCount = compare.lottoNumbers.count { lotto.contains(it) }
        return LottoRank.valueOf(matchingNumberCount)
    }
}
