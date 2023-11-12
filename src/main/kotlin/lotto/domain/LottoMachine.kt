
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

    fun getLottoRank(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int): LottoRank {
        require(bonusNumber in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX) { "보너스 번호는 1부터 45까지의 숫자만 가능합니다." }

        val lottoRank: LottoRank = LottoRank.findByMatchCount(lotto.getMatchCount(winningLotto))

        return if (lottoRank == LottoRank.SECOND && lotto.numberList.contains(bonusNumber)) LottoRank.SECOND_WITH_BONUS else lottoRank
    }
}
