package lotto.domain.number

interface LottoNumberGenerator {
    fun generate(count: Int): List<LottoNumber>
}
