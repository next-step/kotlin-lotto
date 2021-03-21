package lotto.domain

class ManualLottoGenerator(private val lottoNumbers: List<LottoNumber>) : LottoGenerator {

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또넘버 개수는 6개이어야 합니다." }
    }

    override fun generate(): Lotto {
        return Lotto(lottoNumbers)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
