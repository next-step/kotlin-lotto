package lotto.domain.model

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.vo.LottoNumberList
import lotto.domain.model.vo.WinningLottoNumberList

/**
 * 로또 객체
 * */
data class Lotto(val lottoNumberList: LottoNumberList) {

    /**
     * 로또 맞은 횟수 반환
     * */
    fun getMatchCount(winningLottoNumberList: WinningLottoNumberList): Int {
        return lottoNumberList.numberList.filter { winningLottoNumberList.winningNumberList.contains(it) }.size
    }

    companion object {
        fun from(lottoNumberList: List<Int> = LottoNumberList.createPrimitiveLottoNumberList()): Lotto {
            return Lotto(LottoNumberList.valueOf(lottoNumberList))
        }
    }
}
