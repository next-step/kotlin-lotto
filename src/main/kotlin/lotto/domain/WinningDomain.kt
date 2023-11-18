package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoRanking
import lotto.data.WinningLotto

object WinningDomain {

    // 보너스 번호 추가.
    fun checkWinningResult(winningLotto: WinningLotto, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {
        val winningStatusMap = mutableMapOf<LottoRanking, Int>()

        purchaseLottoList.forEach {
            val lottoRanking = LottoMachine.checkLotto(it, winningLotto)
            winningStatusMap[lottoRanking] = winningStatusMap.getOrDefault(lottoRanking, 0) + 1
        }
        return winningStatusMap
    }
}
