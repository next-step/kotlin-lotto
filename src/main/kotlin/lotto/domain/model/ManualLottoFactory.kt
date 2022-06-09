package lotto.domain.model

class ManualLottoFactory(
    private val lottoNumbers: List<Int>
) : LottoFactory {
    override fun create(): Lotto {
        return Lotto.from(lottoNumbers)
    }
}
