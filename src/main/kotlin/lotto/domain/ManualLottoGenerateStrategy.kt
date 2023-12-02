package lotto.domain

class ManualLottoGenerateStrategy(
    private val lottoNumbers: LottoNumbers
) : LottoGenerateStrategy {
    override fun generate(): Lotto {
        return Lotto(lottoNumbers)
    }
}
