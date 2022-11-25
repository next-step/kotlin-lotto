package lotto.domain

object LottoNumberGenerator : NumberGenerator {
    private const val LOTTO_NUMBER_INIT = 0

    override fun generateLottoNumbers(
        possibleNumbers: List<LottoNumber>,
        numberCount: Int
    ): List<LottoNumber> {
        require(numberCount in (LottoNumber.LOTTO_START_NUMBER..LottoNumber.LOTTO_END_NUMBER))
        return possibleNumbers.shuffled()
            .subList(LOTTO_NUMBER_INIT, numberCount)
            .sortedBy { it.number }
    }
}
