package lotto

fun interface LottoGenerateStrategy {
    fun generate(): List<Int>
}
