package lotto.view

import lotto.domain.IssuedLottoMatchStat
import lotto.domain.IssuedLottos

class ResultView {

    fun outputIssuedLottos(issuedLottos: IssuedLottos) {
        println("수동으로 ${issuedLottos.manualCount}장, 자동으로 ${issuedLottos.autoCount}장을 구매했습니다.")
        println(issuedLottos)
    }

    fun outputLottoMatchStat(issuedLottoMatchStat: IssuedLottoMatchStat) {
        println("3개 일치 (5000원) - ${issuedLottoMatchStat.countOfFifth}개")
        println("4개 일치 (50000원) - ${issuedLottoMatchStat.countOfFourth}개")
        println("5개 일치 (1500000원) - ${issuedLottoMatchStat.countOfThird}개")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${issuedLottoMatchStat.countOfSecond}개")
        println("6개 일치 (2000000000원) - ${issuedLottoMatchStat.countOfFirst}개")
    }

    fun outputEarningsRate(earningsRate: Double) {
        val tip = when (earningsRate) {
            1.0 -> "(기준이 1이기 때문에 결과적으로 본전입니다)"
            in 0.0..1.0 -> "(기준이 1이기 때문에 결과적으로 손해입니다)"
            else -> "(기준이 1이기 때문에 결과적으로 이득입니다)"
        }
        println("총 수익률은 ${earningsRate}입니다.$tip")
    }
}
