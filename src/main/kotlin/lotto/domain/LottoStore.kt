package lotto.domain

object LottoStore {
    fun buyLottos(inputPrice: Int): List<Lotto> {
        val lottoCount = inputPrice / LOTTO_PRICE
        this.validateLottoBuy(lottoCount)
        return(1..lottoCount).map { Lotto() }
    }

    private fun validateLottoBuy(lottoCount: Int) {
        require(lottoCount > 0) { throw RuntimeException("로또를 구매할 수 없습니다.") }
    }

    const val LOTTO_PRICE = 1000
}
