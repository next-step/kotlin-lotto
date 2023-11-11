package lotto.domain

object LottoGenerator {
    private val NUMBERS = IntRange(1, 45).toList()

    fun generate(): LottoLine = LottoLine(NUMBERS.shuffled().slice(0..5).sorted().map(::LottoNumber))
}
