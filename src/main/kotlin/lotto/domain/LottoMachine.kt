
package lotto.domain

class LottoMachine {

    fun buyLottoList(buyingPrice: Int): List<Lotto> {
        val lottoCount: Int = buyingPrice / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { Lotto(this.getLottoNumberList()) }
    }

    private fun getLottoNumberList(): List<Int> {
        val lottoNumberList: List<Int> = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()

        return lottoNumberList.shuffled().subList(LOTTO_NUMBER_COUNT_MIN, LOTTO_NUMBER_COUNT_MAX)
    }

    fun getLottoRank(lotto: Lotto, winningLotto: Lotto): LottoRank = LottoRank.findByMatchCount(lotto.getMatchCount(winningLotto))

    companion object {
        private const val LOTTO_NUMBER_COUNT_MIN: Int = 0
        private const val LOTTO_NUMBER_COUNT_MAX: Int = 6
    }
}
