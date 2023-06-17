package lotto.view

import lotto.domain.IssuedLottos
import lotto.domain.LottoMatchStat

class ResultView {

    fun outputIssuedLottos(issuedLottos: IssuedLottos) {
        println("${issuedLottos.lottos.size}개를 구매했습니다.")
        println(issuedLottos)
    }

    fun outputLottoMatchStat(lottoMatchStat: LottoMatchStat) {
        println("3개 일치 (5000원) - ${lottoMatchStat.threeMatchCount}개")
        println("4개 일치 (50000원) - ${lottoMatchStat.fourMatchCount}개")
        println("5개 일치 (1500000원) - ${lottoMatchStat.fiveMatchCount}개")
        println("6개 일치 (2000000000원) - ${lottoMatchStat.sixMatchCount}개")
    }

    fun outputEarningsRate(earningsRate: Double) {
        println("총 수익률은 ${earningsRate}입니다.")
    }
}
