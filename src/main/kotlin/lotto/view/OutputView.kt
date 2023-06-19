package lotto.view

import lotto.Lotto
import lotto.LottoResult
import lotto.Prize

class OutputView {
    fun showInputMoneyMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun showLottoCount(lotto: List<Lotto>) {
        println("${lotto.size}개를 구매했습니다.")
    }

    fun showLotto(lotto: List<Lotto>) {
        lotto.forEach {
            println(it)
        }
    }

    fun showInputWinningNumbersMessage() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun showResult(lottoResult: LottoResult, money: Int) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Prize.Fourth.money}원) - ${lottoResult.getFourthPrize().size}개")
        println("4개 일치 (${Prize.Third.money}원) - ${lottoResult.getThirdPrize().size}개")
        println("5개 일치 (${Prize.Second.money}원) - ${lottoResult.getSecondPrize().size}개")
        println("6개 일치 (${Prize.First.money}원) - ${lottoResult.getFirstPrize().size}개")

        val rateOfReturn = lottoResult.getTotalPrizeMoney().toDouble() / money
        println(String.format("총 수익률은 %.2f입니다.", rateOfReturn))
    }
}
