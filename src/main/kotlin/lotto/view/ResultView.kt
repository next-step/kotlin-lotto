package lotto.view

import lotto.domain.IssuedLottoMatchStat
import lotto.domain.IssuedLottos

class ResultView {

    fun outputIssuedLottos(issuedLottos: IssuedLottos) {
        println("${issuedLottos.lottos.size}개를 구매했습니다.")
        println(issuedLottos)
    }

    fun outputLottoMatchStat(issuedLottoMatchStat: IssuedLottoMatchStat) {
        println("3개 일치 (5000원) - ${issuedLottoMatchStat.countOfThreeMatch}개")
        println("4개 일치 (50000원) - ${issuedLottoMatchStat.countOfFourMatch}개")
        println("5개 일치 (1500000원) - ${issuedLottoMatchStat.countOfFiveMatch}개")
        println("6개 일치 (2000000000원) - ${issuedLottoMatchStat.countOfSixMatch}개")
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
