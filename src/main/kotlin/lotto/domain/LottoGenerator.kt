package lotto.domain

interface LottoGenerator {
    fun generate(size: Int): Lotto
}
