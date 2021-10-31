package lotto.usecase

interface Generator {
    fun generate(numberRange: IntRange): List<Int>
}
