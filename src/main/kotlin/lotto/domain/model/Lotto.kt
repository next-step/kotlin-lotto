package lotto.domain.model

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.vo.LottoNumberList
import lotto.domain.model.vo.WinningLottoNumberList

/**
 * 로또 객체
 * */
data class Lotto(val buyPrice: BuyPrice, val lottoNumberList: LottoNumberList) {

    companion object {
        private const val DEFAULT_BUY_PRICE = "1000"

        fun from(buyPrice: String = DEFAULT_BUY_PRICE, lottoNumberList: List<Int> = LottoNumberList.createPrimitiveLottoNumberList()): Lotto {
            return Lotto(BuyPrice.valueOf(buyPrice), LottoNumberList.valueOf(lottoNumberList))
        }
    }

    /**
     * 로또 맞은 횟수 반환
     * */
    fun getMatchCount(winningLottoNumberList: WinningLottoNumberList): Int {
        return lottoNumberList.numberList.filter { winningLottoNumberList.winningNumberList.contains(it) }.size
    }
}
