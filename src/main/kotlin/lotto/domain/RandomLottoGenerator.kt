package lotto.domain

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER).shuffled()
            .take(Lotto.LOTTO_COUNT)
        return Lotto(lottoNumbers)
    }
}
