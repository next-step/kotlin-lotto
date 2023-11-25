package lottoAuto.domain

class RandomLottoFactory : LottoFactory {
    override fun create(lottoSize: Int): List<Lotto> {
        require(lottoSize >= 0) { "생성할 로또 개수는 0개 미만일 수 없습니다" }
        return List(lottoSize) { Lotto(createShuffledLottoNumbers()) }
    }

    private fun createShuffledLottoNumbers(): List<LottoNumber> {
        return (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(Lotto.LOTTO_SIZE)
            .map { it.toLottoNumber() }
    }
}
