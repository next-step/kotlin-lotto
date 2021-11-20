package lotto.domain

class LottoNumbers(count: Int) {
    private val lottoNumbers = LottoNumberFactory.createLottoNumberList(count)

    fun getLottoNumbers() = lottoNumbers
}
