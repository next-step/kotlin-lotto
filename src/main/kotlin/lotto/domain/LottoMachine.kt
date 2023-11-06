
package lotto.domain

class LottoMachine {

    fun buyLottoList(buyingPrice: Int): List<Lotto> {
        val lottoCount: Int = buyingPrice / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { Lotto(this.getLottoNumberList()) }
    }

    private fun getLottoNumber(): Int = (Math.random() * Lotto.LOTTO_NUMBER_MAX).toInt() + Lotto.LOTTO_NUMBER_MIN

    private fun getLottoNumberList(): List<Int> {
        val lottoNumberList: MutableList<Int> = mutableListOf()

        while (lottoNumberList.size < LOTTO_NUMBER_COUNT_MAX) {
            val lottoNumber: Int = this.getLottoNumber()

            if (!lottoNumberList.contains(lottoNumber)) {
                lottoNumberList.add(lottoNumber)
            }
        }

        return lottoNumberList
    }

    fun getLottoRank(lotto: Lotto, winningLotto: Lotto): LottoRank = LottoRank.findByMatchCount(lotto.getMatchCount(winningLotto))

    companion object {
        private const val LOTTO_NUMBER_COUNT_MAX: Int = 6
    }
}
