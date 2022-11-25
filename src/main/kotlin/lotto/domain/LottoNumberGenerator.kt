package lotto.domain

object LottoNumberGenerator : NumberGenerator {
    private const val LOTTO_NUMBER_INIT = 0

    override fun generateLottoFromNumbers(possibleNumbers: List<LottoNumber>): Lotto {
        val numberList =
            possibleNumbers.shuffled()
                .subList(LOTTO_NUMBER_INIT, Lotto.LOTTO_NUMBER_COUNT)
                .sortedBy { it.number }
        return Lotto(numberList.toMutableSet())
    }
}
