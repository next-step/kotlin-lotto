package lotto.domain

class ManualLottos(manualLottoStrings: ManualLottoStrings) {
    val manualLottos: List<Lotto>

    init {
        manualLottos = manualLottoStrings.lottoStrings.map { manualLottoString ->
            val stringNumbers = StringNumbers(manualLottoString)
            val lottoNumbers = stringNumbers.numbers.map { numberStr ->
                LottoNumber(numberStr.trim().toInt())
            }
            Lotto(lottoNumbers.toSet())
        }
    }
}
