package lotto.domain

class RandomLottoGenerator : LottoGenerator {

    private val lottoNumbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)

    override fun generate(): Lotto {
        val randomLottoNumbers = lottoNumbers.shuffled()
            .take(Lotto.LOTTO_COUNT)
        return Lotto(randomLottoNumbers)
    }
}
