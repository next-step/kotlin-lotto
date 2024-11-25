package lotto.domain

fun interface LottoNumberGenerator {
    fun generate(): List<LottoNumber>
}
