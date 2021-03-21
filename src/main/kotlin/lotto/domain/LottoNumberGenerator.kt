package lotto.domain

interface LottoNumberGenerator {
    fun pickNumber(): Set<LottoNumber>
}
