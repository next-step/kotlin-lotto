package lotto.domain

internal interface LottoNumsGenerator {
    fun generate(): List<LottoNum>
}
