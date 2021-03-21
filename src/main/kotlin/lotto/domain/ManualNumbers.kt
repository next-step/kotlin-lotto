package lotto.domain

class ManualNumbers(
    private val values: List<String>
) {
    fun toLottos(): List<Lotto> {
        return values.map {
            toLotto(
                LottoNumberTokenizer.tokenize(it)
            )
        }
    }

    private fun toLotto(manualLottoToken: List<Int>): Lotto {
        val lottoNumbers = manualLottoToken.map { LottoNumber.from(it) }
        return Lotto.from(lottoNumbers)
    }
}
