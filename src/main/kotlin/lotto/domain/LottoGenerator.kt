package lotto.domain

interface LottoGenerator {
    fun generateLotto(numbers: List<Int>): Lotto
    fun generateLotto(): Lotto
}
