package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicketCount
import lotto.domain.WinningBallResult
import lotto.domain.WinningBalls

object InputView {
    fun getPurchaseAmount(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readln()
        require(amount.isNotEmpty()) { "금액을 입력해주세요." }

        return amount.toInt()
    }

    fun getManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualTicketCount = readln()

        return manualTicketCount.toInt()
    }

    fun getNumberOfPurchases(lottoTicketCount: LottoTicketCount) {
        println("수동으로 ${lottoTicketCount.manualTicketCount}장, 자동으로 ${lottoTicketCount.autoTicketCount}개를 구매했습니다.")
    }

    fun getWinningBalls(): WinningBallResult {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) { "당첨 번호를 입력해주세요." }
        val winningBalls = WinningBalls(winningNumber.split(", ").map { LottoNumber(it.toInt()) }.toSet())
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = LottoNumber(readln().toInt())

        return WinningBallResult(winningBalls, bonusBall)
    }
}
