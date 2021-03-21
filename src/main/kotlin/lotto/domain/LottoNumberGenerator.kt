package lotto.domain

interface LottoNumberGenerator {
    fun pickNumber(): List<LottoNumber>
}
