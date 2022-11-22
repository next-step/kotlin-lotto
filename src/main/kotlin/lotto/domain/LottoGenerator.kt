package lotto.domain

fun interface LottoGenerator {
    fun generateLotto(numbers: List<Int>): Lotto
}
