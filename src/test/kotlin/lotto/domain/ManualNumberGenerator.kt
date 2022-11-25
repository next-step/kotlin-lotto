package lotto.domain

class ManualNumberGenerator : NumberGenerator {
    override fun generateLottoFromNumbers(possibleNumbers: List<LottoNumber>): Lotto {
        val numberList =
            possibleNumbers
                .subList(0, Lotto.LOTTO_NUMBER_COUNT)
                .toMutableSet()

        return Lotto(numberList)
    }
}
