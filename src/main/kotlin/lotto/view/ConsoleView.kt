package lotto.view

import lotto.GameResult
import lotto.Lotto
import lotto.Lottos
import lotto.Prize
import lotto.vo.LottoNumber
import lotto.vo.Money
import lotto.vo.WinningNumbers
import kotlin.math.floor

object ConsoleView : InputView, OutputView {
    override fun receiveMoney(): Money {
        println("구입금액을 입력해 주세요.")
        val moneyInput = readln()
            .toIntOrNull()
            ?: throw IllegalArgumentException("구입금액은 숫자여야 합니다.")
        return Money(moneyInput)
    }

    override fun receiveWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
            .split(", ")
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
            }
            .map(LottoNumber::from)

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readln()
            .toIntOrNull()
            ?: throw IllegalArgumentException("보너스 볼은 숫자여야 합니다.")

        return WinningNumbers(winningNumbers, LottoNumber.from(bonusNumber))
    }

    override fun showPurchased(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { it ->
            println(changeToConsoleFormat(it))
        }
        println()
    }

    private fun changeToConsoleFormat(lotto: Lotto): String {
        return lotto.numbers
            .sorted()
            .joinToString(", ", "[", "]")
    }

    override fun show(result: GameResult) {
        println()
        println("당첨 통계")
        println("---------")
        result
            .prizes
            .forEach { (prize, count) ->
                println("${createMatchingDescriptionOf(prize)} (${prize.amount}원)- ${count}개")
            }
        println("총 수익률은 ${floor(result.profitRate * 100) / 100}입니다.")
    }

    private fun createMatchingDescriptionOf(prize: Prize) = "${prize.condition}개 일치${if (prize == Prize.MATCH_5_BONUS) ", 보너스 볼 일치" else ""}"
}
