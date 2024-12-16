package lotto.domain

data class Lotto(
    val lottoNumbers: LottoNumbers,
) {
    fun matchLotto(
        winnerNumbers: LottoNumbers,
        bonusNumber: LottoNumber,
    ): LottoRank {
        val matchingNumbers = lottoNumbers.numbers.count { winnerNumbers.contains(it) }
        val matchingBonus = lottoNumbers.contains(bonusNumber)
        return LottoRank.from(matchingNumbers, matchingBonus)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
