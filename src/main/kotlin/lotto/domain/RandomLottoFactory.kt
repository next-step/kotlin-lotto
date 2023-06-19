package lotto.domain

class RandomLottoFactory : LottoFactory {

    override fun create(): Lotto {
        val shuffled = lottoNumbers.shuffled()
        return Lotto(shuffled.subList(0, 6))
    }

    companion object {
        private val lottoNumbers = LottoNumber.lottoNumbers();
    }
}