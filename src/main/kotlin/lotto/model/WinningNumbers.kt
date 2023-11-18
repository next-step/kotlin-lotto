package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    fun toRank(otherNumber: LottoNumbers): Rank {
        return Rank.of(
            this.lottoNumbers.numbersIntersections(otherNumber),
            otherNumber.containNumber(this.bonusNumber)
        )
    }
}
