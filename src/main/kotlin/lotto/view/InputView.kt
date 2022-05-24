package lotto.view

import lotto.dto.LottoBuyingRequest
import lotto.dto.WinningLottoRequest

object InputView {
    private const val INPUT_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun buying(): LottoBuyingRequest {
        println(INPUT_AMOUNT)
        return LottoBuyingRequest(readln().toBigDecimal())
    }

    fun winningLotto(): WinningLottoRequest {
        println(INPUT_WINNING_LOTTO)
        val winningLottoNumbers = readln()
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = readln()
        return WinningLottoRequest(winningLottoNumbers, bonusNumber)
    }
}
