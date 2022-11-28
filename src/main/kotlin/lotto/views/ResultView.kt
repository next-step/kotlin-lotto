package lotto.views

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.WalletResult

object ResultView {

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it)
        }
    }

    fun printResult(walletResult: WalletResult) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoResult.FourthWin.KRW}원)- ${walletResult.getFourthWinCount()}개")
        println("4개 일치 (${LottoResult.ThirdWin.KRW}원)- ${walletResult.getThirdWinCount()}개")
        println("4개 일치 (${LottoResult.SecondWin.KRW}원)- ${walletResult.getSecondWinCount()}개")
        println("4개 일치 (${LottoResult.FirstWin.KRW}원)- ${walletResult.getFirstWinCount()}개")
        println("총 수익률은 ${walletResult.getRateOfReturn()}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
