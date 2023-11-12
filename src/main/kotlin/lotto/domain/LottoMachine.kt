
package lotto.domain

class LottoMachine {

    fun buyLottoList(buyingPrice: Int): List<Lotto> {
        val lottoCount: Int = buyingPrice / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { Lotto(this.getLottoNumberList()) }
    }

    private fun getLottoNumberList(): List<Int> {
        val lottoAreaList: List<Int> = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()

        return lottoAreaList.shuffled().subList(Lotto.NUMBER_COUNT_MIN, Lotto.NUMBER_COUNT_MAX)
    }
}
