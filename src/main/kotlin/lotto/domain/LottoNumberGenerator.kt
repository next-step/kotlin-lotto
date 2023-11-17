package lotto.domain

fun interface LottoNumberGenerator {
    fun generateNumber(): List<LottoNumber>
}
