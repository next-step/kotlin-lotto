package lottoview

import lotto.LottoWinningHandler.matchCount
import lotto.LottoWinningInfo

object LottoOutputView {

    fun resultForWinning(issuedLottos: List<List<Int>>, winningInfo: LottoWinningInfo) {
        println(WINNING_STATISTICS_MESSAGE)
        println(SEPARATOR_MESSAGE)

        matchCount(issuedLottos, winningInfo).forEach {
            if(it.value > 0) {
                println(it.key.toString() + CONTAIN_MESSAGE + it.value.toString())
            }
        }

//        총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    }

    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val SEPARATOR_MESSAGE = "---------"
    const val CONTAIN_MESSAGE = "개 일치 (5000원) - "
//    const val FOUR_CONTAIN_MESSAGE = "4개 일치 (50000원) - "
//    const val FIVE_CONTAIN_MESSAGE = "5개 일치 (1500000원) - "
//    const val SIX_CONTAIN_MESSAGE = "6개 일치 (2000000000원) - "
}