package lotto.domain

class Lotto(
    val numbers: LottoNumbers = LottoNumbers.random(),
) {
    fun calculateResult(
        winningNumbers: LottoNumbers,
        bonusNumber: LottoNumber,
    ): LottoRank? {
        return LottoRank.of(
            matchCount = numbers.getMatchCount(winningNumbers),
            isBonusNumberMatch = numbers.isContains(bonusNumber),
        )
    }

    companion object {
        const val PRICE = 1000
    }
}
