package lottoAuto.domain

object LottoFactory {
    fun create(purchaseAmount: Int): List<Lotto> {
        val numOfLotto = purchaseAmount / Lotto.LOTTO_PRICE
        return List(numOfLotto) { Lotto(createShuffledLottoNumbers()) }
    }

    private fun createShuffledLottoNumbers(): List<LottoNumber> {
        return (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(Lotto.LOTTO_SIZE)
            .map { it.toLottoNumber() }
    }
}
