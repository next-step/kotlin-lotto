package lotto.domain

object LottoNumber {
    private val NUMBERS = IntRange(1, 45).toList()

    fun generate(): List<Int> = NUMBERS.shuffled().slice(0 .. 5).sorted()
}
