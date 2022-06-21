package lotto.domain

interface LottoNumberGenerator {
    fun generate(): List<LottoNumber>
}
