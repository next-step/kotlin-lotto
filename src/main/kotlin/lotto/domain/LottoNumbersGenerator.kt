package lotto.domain

interface LottoNumbersGenerator {
    fun generate(count: Int): List<LottoNumber>
}
