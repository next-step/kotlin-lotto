
package lotto.domain

class LottoMachine(private val money: Int = 0) {

    fun buyLottoList(): List<Lotto> {
        val lottoCount: Int = this.money / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { Lotto(this.getLottoNumberList()) }
    }

    fun buyLotto(lottoNumberList: List<Int>): Lotto = Lotto(lottoNumberList)

    private fun getLottoNumberList(): List<Int> {
        val lottoAreaList: List<Int> = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()

        return lottoAreaList.shuffled().subList(Lotto.NUMBER_COUNT_MIN, Lotto.NUMBER_COUNT_MAX)
    }
}
