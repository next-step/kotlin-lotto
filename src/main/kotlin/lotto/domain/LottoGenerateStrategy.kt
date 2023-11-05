package lotto.domain

fun interface LottoGenerateStrategy {
    fun generate(): List<Int>
}
