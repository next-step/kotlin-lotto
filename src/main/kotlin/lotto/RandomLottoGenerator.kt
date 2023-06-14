package lotto

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }

        return Lotto(lottoNumbers)
    }
}
