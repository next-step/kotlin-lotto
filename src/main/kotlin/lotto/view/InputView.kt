package lotto.view

import lotto.model.LottoNumber
import lotto.model.WinningNumbers
import lotto.view.order.impl.LottoManualOrderStrategy

object InputView {

    private const val LOTTO_NUMBER_DELIMITER = ","

    fun amountLottoOrder(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun manualOrderCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun manualOrderNumbers(count: Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count)
            .map { requireNotNull(readlnOrNull()) }
    }

    fun selectWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lottoGame = LottoManualOrderStrategy.manualIssue(readln())
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber((readlnOrNull() ?: "").toInt())
        return WinningNumbers(lottoGame, bonusNumber)
    }
}
