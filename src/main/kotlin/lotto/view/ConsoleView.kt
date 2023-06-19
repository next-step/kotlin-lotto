package lotto.view

import lotto.GameResult
import lotto.Lottos
import lotto.vo.LottoNumber
import lotto.vo.Money
import kotlin.math.floor

object ConsoleView : InputView, OutputView {
    override fun receiveMoney(): Money {
        println("구입금액을 입력해 주세요.")
        val moneyInput = readln()
            .toIntOrNull()
            ?: throw IllegalArgumentException("구입금액은 숫자여야 합니다.")
        return Money(moneyInput)
    }

    override fun receiveWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
            .split(", ")
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
            }
            .map(::LottoNumber)
    }

    override fun showPurchased(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        println()
    }

    override fun show(result: GameResult) {
        println()
        println("당첨 통계")
        println("---------")
        result
            .prizes
            .forEach { (prize, count) ->
                println("${prize.condition}개 일치 (${prize.amount}원)- ${count}개")
            }
        println("총 수익률은 ${floor(result.profitRate * 100) / 100}입니다.")
    }
}
