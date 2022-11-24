package lotto

class LottoGenerator {
    val range = IntRange(1, 45)

    fun generate(): List<Int> {
        return range.shuffled().subList(0, 6)
    }
}
