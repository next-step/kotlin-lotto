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
        Prize.entries
            .filter { it != Prize.NONE }
            .sortedByDescending { it.count }
            .forEach { prize ->
                println("${prize.count}개 일치 (${prize.money}원) - ${lottoResult[prize]}개")
            }

        println(String.format("총 수익률은 %.2f입니다.", lottoResult.getRateOfReturn(money)))
    }
}
