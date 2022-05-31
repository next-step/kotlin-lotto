package lotto.model

object LottoGenerator {

    private const val LOTTO_NUMBER_COUNT = 6

    fun generate(): Lotto {
        val shuffled = LottoNumber.LOTTO_NUMBERS.shuffled()
        return Lotto(shuffled.subList(0, LOTTO_NUMBER_COUNT))
    }
}
