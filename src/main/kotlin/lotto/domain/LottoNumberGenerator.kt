package lotto.domain

interface LottoNumberGenerator {
    fun generateNumbers(): List<LottoNumber>
}
