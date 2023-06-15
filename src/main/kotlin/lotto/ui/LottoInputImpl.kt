package lotto.ui

import lotto.domain.request.LottoOrderRequest
import lotto.domain.request.WinningInfoRequest

private const val REQUEST_NUMBER_MESSAGE = "숫자를 입력해 주세요."

private const val DELIMITER = ","

object LottoInputImpl : LottoInput {

    override fun requestOrderLotto(): LottoOrderRequest {
        val money = requestMoney()
        val manualCount = requestPurchaseQuantity()
        val manualNumbersList = requestManualLottoNumbersList(manualCount)

        return LottoOrderRequest(
            money = money, manualCount = manualCount, manualNumbersList = manualNumbersList
        )
    }

    override fun requestWinningInfo(): WinningInfoRequest = WinningInfoRequest(
        values = requestWinningNumbers(),
        bonusNumber = requestBonusNumber()
    )

    private fun requestMoney(): Long = promptAndReadLongNotNull("구입금액을 입력해 주세요.")

    private fun requestPurchaseQuantity(): Int = promptAndReadNumberNotNull("\n수동으로 구매할 로또 수를 입력해 주세요.")

    private fun requestManualLottoNumbersList(size: Int): List<Set<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..size).map {
            promptAndReadNotNull(
                prompt = "[$it / $size]",
                failedPrompt = "유효한 번호를 입력해주세요."
            )
        }.map { it.split(DELIMITER).map(String::trim).map(String::toInt).toSet() }
    }

    private fun requestWinningNumbers(): List<Int> {
        val winningNumbers = promptAndReadNotNull(
            prompt = "지난 주 당첨 번호를 입력해 주세요.",
            failedPrompt = "유효한 당첨 번호를 입력해주세요."
        )

        return winningNumbers.split(DELIMITER).map(String::trim).map(String::toInt)
    }

    private fun requestBonusNumber(): Int = promptAndReadNumberNotNull("보너스 볼을 입력해 주세요.")

    private tailrec fun promptAndReadNumberNotNull(prompt: String, failedPrompt: String = REQUEST_NUMBER_MESSAGE): Int {
        val result = promptAndReadNumber(prompt)

        return if (result == null) {
            println(failedPrompt)
            promptAndReadNumberNotNull(prompt, failedPrompt)
        } else {
            result
        }
    }

    private fun promptAndReadLongNotNull(prompt: String, failedPrompt: String = REQUEST_NUMBER_MESSAGE): Long {
        val result = promptAndReadLong(prompt)

        return if (result == null) {
            println(failedPrompt)
            promptAndReadLongNotNull(prompt, failedPrompt)
        } else {
            result
        }
    }

    private tailrec fun promptAndReadNotNull(prompt: String, failedPrompt: String): String {
        val result = promptAndRead(prompt)

        return if (result == null) {
            println(failedPrompt)
            promptAndReadNotNull(prompt, failedPrompt)
        } else {
            result
        }
    }

    private fun promptAndReadLong(prompt: String): Long? {
        return promptAndRead(prompt)?.toLongOrNull()
    }

    private fun promptAndReadNumber(prompt: String): Int? {
        return promptAndRead(prompt)?.toIntOrNull()
    }

    private fun promptAndRead(prompt: String): String? {
        println(prompt)
        return readlnOrNull()?.trim()
    }
}
