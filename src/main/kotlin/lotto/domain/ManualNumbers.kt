package lotto.domain

class ManualNumbers(
    private val values: List<String>
) {
    fun toManualLottoNumber(): List<Lotto> {
        return values.map {
            toManualLotto(
                LottoNumberTokenizer.tokenize(it)
            )
        }
    }

    private fun toManualLotto(manualLottoToken: List<Int>): Lotto {
        val lottoNumbers = manualLottoToken.map { LottoNumber.from(it) }
        return Lotto.from(lottoNumbers)
    }
}
