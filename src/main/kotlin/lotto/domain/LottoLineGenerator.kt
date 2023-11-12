package lotto.domain

object LottoLineGenerator {
    val LOTTO_NUMBER_RANGE = IntRange(1, 45)
    private val NUMBERS = LOTTO_NUMBER_RANGE.toList()

    fun generate(): LottoLine = LottoLine.valueOf(NUMBERS.shuffled().slice(0..5).sorted().joinToString(LottoLine.LOTTO_NUMBER_DELIMITER))
}
