package next.step.lotto.domain

interface LottoNumberGenerator {
    fun generate(): Set<LottoNumber>
}