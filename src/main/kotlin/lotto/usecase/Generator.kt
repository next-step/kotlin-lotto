package lotto.usecase

interface Generator {
    fun generate(range: IntRange): List<Int>
}
