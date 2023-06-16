package lotto.view

import lotto.domain.LottoMachine

object ResultView {
    fun endGameForCannotBuy() {
        println("로또를 구매할 수 없어 게임을 종료합니다")
    }

    fun showBuyResult(lottoCount: Int, buyedLotto: List<List<Int>>) {
        println("${lottoCount}개를 구매했습니다.")
        buyedLotto.forEach {
            println(it)
        }
    }

    fun showGameResult() {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoMachine.LOTTO_WINNER_THREE}원)- ${LottoMachine.threeCorrect}개")
        println("4개 일치 (${LottoMachine.LOTTO_WINNER_FOUR}원)- ${LottoMachine.fourCorrect}개")
        println("5개 일치 (${LottoMachine.LOTTO_WINNER_FIVE}원)- ${LottoMachine.fiveCorrect}개")
        println("6개 일치 (${LottoMachine.LOTTO_WINNER_SIX}원)- ${LottoMachine.sixCorrect}개")
        val result = if (LottoMachine.rateOfReturn > 1) "이익" else "손해"
        println("총 수익률은 ${String.format("%.2f", LottoMachine.rateOfReturn)}입니다.(기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }
}
