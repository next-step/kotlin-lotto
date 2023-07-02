package lotto.domain

interface LottoNumberGenerationStrategy {
    fun generateLottoNumber(): List<LottoNumber>
}
