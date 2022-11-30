package lotto.ui.view

import lotto.domain.LottoResult

object ResultView {
    fun printLottoResult(lottoResult: LottoResult) {
        println(
            "당첨 결과\n"
            + "---------\n"
            + "3개 일치 (5000원)- ${lottoResult.winningAmountList[5000]}개\n"
            + "4개 일치 (50000원)- ${lottoResult.winningAmountList[50000]}개\n"
            + "5개 일치 (1500000원)- ${lottoResult.winningAmountList[1500000]}개\n"
            + "6개 일치 (2000000000원)- ${lottoResult.winningAmountList[2000000000]}개\n"
            + "총 수익률은 ${lottoResult.calculateReturnRate()}입니다."
        )
    }
}