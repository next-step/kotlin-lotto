package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking

object WinningDomain {

    fun checkWinningResult(winningNumberList: List<Int>, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {
        val winningStatusMap = mutableMapOf<LottoRanking, Int>()
        val winningLotto = LottoMachine.createSelectLotto(LottoNumber.createLottoNumbers(winningNumberList))

        purchaseLottoList.forEach {
            val lottoRanking = LottoMachine.checkLotto(winningLotto, it)
            winningStatusMap[lottoRanking] = winningStatusMap.getOrDefault(lottoRanking, 0) + 1
        }
        return winningStatusMap
    }
}
