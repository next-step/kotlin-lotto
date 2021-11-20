package lotto.domain

object LottoNumberFactory {
    fun createLottoNumberList(count: Int): List<LottoNumber> {
        val lottoNumbers = mutableListOf<LottoNumber>()
        repeat(count) {
            lottoNumbers.add(LottoNumber())
        }
        return lottoNumbers
    }
}
