package lotto.domain

class LottoNumbers(count: Int, lottoNumberFactory: LottoNumberFactory) {
    private val lottoNumbers = lottoNumberFactory.createLottoNumberList(count)

    fun getLottoNumbers() = lottoNumbers
}
