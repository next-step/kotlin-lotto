package autolotto.view

import autolotto.domain.Amount
import autolotto.domain.LottoNumber
import autolotto.domain.WinningLottoNumber

object InputView {
    fun printLottoGameCount(gameCount: Int) {
        println("${gameCount}개를 구매했습니다.")
    }

    fun getLottoPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        val input: Int = readlnOrNull()?.toIntOrNull() ?: throw RuntimeException("숫자를 입력해주세요")
        return Amount(input)
    }

    fun getWinningNumber(): WinningLottoNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String = readlnOrNull() ?: throw RuntimeException("당첨 번호를 입력해주세요")
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber: Int =
            readlnOrNull()?.toIntOrNull() ?: throw RuntimeException("보너스 번호는 숫자를 입력해주세요")
        return WinningLottoNumber(LottoNumber(splitWinningNumbers(input)), bonusNumber)
    }

    private fun splitWinningNumbers(input: String): Set<Int> {
        return input.split(",").map { e -> e.trim().toInt() }.toSet()
    }
}
