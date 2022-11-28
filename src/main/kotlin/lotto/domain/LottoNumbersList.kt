package lotto.domain

object LottoNumbersList {
    private val lottoNumbersList = mutableListOf<LottoNumbers>()

    fun setLottoNumbers(lottoNumbers: LottoNumbers) {
        lottoNumbersList.add(lottoNumbers)
    }

    fun getLottoNumbers(): List<LottoNumbers> {
        return lottoNumbersList.toList()
    }

    fun getList(): List<List<Int>> {
        return lottoNumbersList.map { it.value.map { lottoNumber -> lottoNumber.value } }
    }
}
