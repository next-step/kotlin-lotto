package lotto.domain

interface LottoNumberGenerator {
    fun generate(count: Int): List<LottoNumber>
}
