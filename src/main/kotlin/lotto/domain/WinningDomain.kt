package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoRanking
import lotto.data.WinningLotto
import java.util.EnumMap

object WinningDomain {

    // 보너스 번호 추가.
    fun checkWinningResult(winningLotto: WinningLotto, purchaseLottoList: List<Lotto>): EnumMap<LottoRanking, Int> {
        val winningStatusMap: EnumMap<LottoRanking, Int> = EnumMap(LottoRanking::class.java)

        purchaseLottoList.forEach {
            val lottoRanking = LottoMachine.checkLotto(it, winningLotto)
            winningStatusMap[lottoRanking] = winningStatusMap.getOrDefault(lottoRanking, 0) + 1
        }
        return winningStatusMap
    }
}
