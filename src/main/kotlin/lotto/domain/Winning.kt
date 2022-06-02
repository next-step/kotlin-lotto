package lotto.domain

class Winning private constructor(
    private val lottoNumbers: LottoNumbers
) {
    fun matchResult(lotto: Lotto): WinningAmount {
        return WinningAmount.findByMatchCount(
            matchCount = lottoNumbers.matchedNumberCount(other = lotto.lottoNumbers)
        )
    }

    companion object {
        fun of(numbers: List<Int>): Winning = Winning(LottoNumbers(convertToLottoNumberSet(numbers)))

        private fun convertToLottoNumberSet(numbers: List<Int>) =
            numbers.map { LottoNumber.from(it) }
                .toSet()
    }
}
