package lotto.view

import lotto.dto.LottoBuyingRequest
import lotto.dto.WinningLottoRequest
import java.math.BigDecimal

object InputView {
    private const val INPUT_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun buying(): LottoBuyingRequest {
        val amount = amount()
        val manualCount = manualCount()
        val manualNumbers = manualNumbers(manualCount)
        return LottoBuyingRequest(
            amount = amount,
            manualCount = manualCount,
            manualNumbers = manualNumbers
        )
    }

    private fun amount(): BigDecimal {
        println(INPUT_AMOUNT)
        return readln().toBigDecimal()
            .also { println() }
    }

    private fun manualCount(): Int {
        println(INPUT_MANUAL_COUNT)
        return readln().toInt()
            .also { println() }
    }

    private fun manualNumbers(manualCount: Int): List<String> {
        println(INPUT_MANUAL_NUMBER)
        return List(manualCount) { index ->
            print("${index + 1}. ")
            readln()
        }.also { println() }
    }

    fun winningLotto(): WinningLottoRequest {
        println(INPUT_WINNING_LOTTO)
        val winningLottoNumbers = readln()
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = readln()
        return WinningLottoRequest(winningLottoNumbers, bonusNumber)
    }
}
