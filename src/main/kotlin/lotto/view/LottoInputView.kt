package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoQuantity
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.domain.response.LottosGenerateRequest
import lotto.view.request.ManualLottosRequest

object LottoInputView {
    private const val WINNING_LOTTO_DELIMITER = ","

    fun inputLottoGenerateRequest(): LottosGenerateRequest {
        val money = inputMoney()
        val manualLottosRequest = inputManualLottoView()
        return LottosGenerateRequest(
            money = money,
            manualLottoNumbers = manualLottosRequest.lottoNumbers,
        )
    }

    private fun inputMoney(): Money {
        return Money(readLineWithMessage("구입금액을 입력해 주세요.").trim().toInt())
    }

    private fun inputManualLottoView(): ManualLottosRequest {
        val manualLottoCount = inputManualLottoCount()
        if (manualLottoCount.value == 0) {
            return ManualLottosRequest()
        }

        val manualLottoNumbers = inputManualLottoNumbers(manualLottoCount)
        return ManualLottosRequest(
            lottoQuantity = manualLottoCount,
            lottoNumbers = manualLottoNumbers,
        )
    }

    private fun inputManualLottoCount(): LottoQuantity {
        return LottoQuantity(readLineWithMessage("수동으로 구매할 로또 수를 입력해 주세요.").trim().toInt())
    }

    private fun inputManualLottoNumbers(manualLottoCount: LottoQuantity): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount.value) {
            readln().toLottoNumbers()
        }
    }

    fun inputWinningLotto(): WinningLotto {
        val winningLottoNumbers = inputWinningLottoNumbers()
        val bonusNumber = inputBonusNumber()
        return WinningLotto(
            numbers = winningLottoNumbers,
            bonusNumber = bonusNumber,
        )
    }

    private fun inputWinningLottoNumbers(): LottoNumbers {
        return readLineWithMessage("지난 주 당첨 번호를 입력해 주세요.").toLottoNumbers()
    }

    private fun inputBonusNumber(): LottoNumber {
        return LottoNumber(readLineWithMessage("보너스 볼을 입력해 주세요.").trim().toInt())
    }

    private fun readLineWithMessage(message: String): String {
        println(message)
        return readln()
    }

    private fun readln(): String {
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }

    private fun String.toLottoNumbers(): LottoNumbers {
        return this.split(WINNING_LOTTO_DELIMITER)
            .map { it.trim().toInt() }
            .let { LottoNumbers.from(it.toSet()) }
    }
}
