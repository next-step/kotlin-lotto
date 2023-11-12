package lotto.domain

object LottoGenerator {
    val LOTTO_NUMBER_RANGE = IntRange(1, 45)
    private val NUMBERS = LOTTO_NUMBER_RANGE.toList()

    fun generate(): LottoLine = LottoLine(NUMBERS.shuffled().slice(0..5).sorted().map(LottoNumber::from))
}
