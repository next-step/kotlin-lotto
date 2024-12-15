package lotto.ui

import lotto.common.RetryHandler
import lotto.domain.LottoAmount
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.ManualLottos

object LottoGameReader {
    fun readAmount(): LottoAmount {
        return RetryHandler.retryIfFail(
            mainAction = {
                LottoGamePrinter.printAmountMessage()
                val str = ConsoleReader.readLine()
                LottoAmount(convertToNumber(str).toLong())
            },
            retryAction = {
                readAmount()
            },
        )
    }

    fun readWinningLottoNumbers(): LottoNumbers {
        return RetryHandler.retryIfFail(
            mainAction = {
                LottoGamePrinter.printWinningLottoNumberMessage()
                readLottoNumbers()
            },
            retryAction = {
                readWinningLottoNumbers()
            },
        )
    }

    fun readBonusNumber(): LottoNumber {
        return RetryHandler.retryIfFail(
            mainAction = {
                LottoGamePrinter.printBonusNumberMessage()
                val str = ConsoleReader.readLine()
                LottoNumber(convertToNumber(str))
            },
            retryAction = {
                readBonusNumber()
            },
        )
    }

    fun readManualCount(): Int {
        return RetryHandler.retryIfFail(
            mainAction = {
                LottoGamePrinter.printManualCountMessage()
                val str = ConsoleReader.readLine()
                convertToNumber(str)
            },
            retryAction = {
                readManualCount()
            },
        )
    }

    fun readManualLottos(manualCount: Int): ManualLottos {
        return RetryHandler.retryIfFail(
            mainAction = {
                LottoGamePrinter.printManualNumbersMessage()
                val lottos =
                    (1..manualCount).map {
                        Lotto(readLottoNumbers())
                    }

                ManualLottos(lottos)
            },
            retryAction = {
                readManualLottos(manualCount)
            },
        )
    }

    private fun readLottoNumbers(): LottoNumbers {
        val lottoNumbers =
            ConsoleReader.readLine()
                .split(",")
                .map { str -> convertToNumber(str) }
                .map { number -> LottoNumber(number) }
                .toSet()

        return LottoNumbers(lottoNumbers)
    }

    private fun convertToNumber(str: String): Int {
        val number = str.trim().toIntOrNull()
        requireNotNull(number) { "숫자만 입력해야 합니다. 현재 입력=$str" }
        return number
    }
}
