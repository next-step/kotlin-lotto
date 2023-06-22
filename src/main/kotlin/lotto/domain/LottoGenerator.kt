package lotto.domain

interface LottoGenerator {
    fun generate(numbers: List<Int>): Lotto
}
