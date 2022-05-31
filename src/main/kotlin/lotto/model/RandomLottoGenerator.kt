package lotto.model

object RandomLottoGenerator {

    private const val LOTTO_NUMBER_COUNT = 6

    fun generate(): List<LottoNumber> =
        LottoNumber.LOTTO_NUMBERS.shuffled()
            .subList(0, LOTTO_NUMBER_COUNT)
}
