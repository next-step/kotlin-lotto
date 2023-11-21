package lottoAuto.domain

class RandomLottoFactory : LottoFactory {
    override fun create(lottoSize: Int): List<Lotto> {
        return List(lottoSize) { Lotto(createShuffledLottoNumbers()) }
    }

    private fun createShuffledLottoNumbers(): List<LottoNumber> {
        return (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(Lotto.LOTTO_SIZE)
            .map { it.toLottoNumber() }
    }
}
