package lotto.domain

class ManualLottoNumbersGenerateStrategy(
    private val lottoNumbers: List<Int>,
) : LottoNumbersGenerateStrategy {
    override fun generate(): LottoNumbers {
        return LottoNumbers.of(lottoNumbers)
    }
}
