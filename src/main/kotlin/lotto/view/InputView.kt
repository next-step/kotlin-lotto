package lotto.view

import lotto.ball.BonusBall
import lotto.number.Numbers

object InputView {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력하세요.")
        return readlnOrNull()?.toInt() ?: 0
    }

    fun inputLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getInputNumberList()
    }

    fun inputBonusBall(): BonusBall {
        println("보너스 볼을 입력해주세요.")
        return BonusBall(readlnOrNull()?.toInt() ?: 0)
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: 0
    }

    fun inputManualLottoNumbers(lottoCount: Int): List<Numbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return generateLottoList(lottoCount)
    }

    private fun generateLottoList(lottoCount: Int) =
        (1..lottoCount)
            .map { Numbers(numbers = getInputNumberList()) }
            .toList()

    private fun getInputNumberList(): List<Int> =
        (readlnOrNull() ?: "")
            .split(",")
            .map { it.trim().toInt() }
}
