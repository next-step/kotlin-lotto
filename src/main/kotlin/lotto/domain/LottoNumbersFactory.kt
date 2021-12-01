package lotto.domain

class LottoNumbersFactory(private val lottoNumberFactory: LottoNumberFactory) {
    fun create(count: Int) = LottoNumbers(count, lottoNumberFactory)
}
