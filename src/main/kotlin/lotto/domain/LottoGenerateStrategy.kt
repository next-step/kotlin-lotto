package lotto.domain

interface LottoGenerateStrategy {
    fun generate(): Set<LottoNumber>
}
