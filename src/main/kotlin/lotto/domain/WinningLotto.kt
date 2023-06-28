package lotto.domain

class WinningLotto(val lotto: Lotto, val bonus: LottoNumber) {
    init {
        require(!lotto.contains(bonus)) { println("보너스 번호는 당첨 번호에 포함 되지 않아야 합니다.") }
    }
    fun rank(compare: Lotto): LottoRank {
        val matchingNumberCount = compare.lottoNumbers.count { lotto.contains(it) }
        val matchingBonus = compare.contains(bonus)
        return LottoRank.valueOf(matchingNumberCount, matchingBonus)
    }
}
