package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.ManualLottos

object LottoGameReader {
    fun readAmount(): Int {
        LottoGamePrinter.printAmountMessage()
        val str = ConsoleReader.readLine()
        return convertToNumber(str)
    }

    fun readWinningLottoNumbers(): Set<LottoNumber> {
        LottoGamePrinter.printWinningLottoNumberMessage()
        return readLottoNumbers()
    }

    fun readBonusNumber(): LottoNumber {
        LottoGamePrinter.printBonusNumberMessage()
        val str = ConsoleReader.readLine()
        return LottoNumber(convertToNumber(str))
    }

    fun readManualLottos(): ManualLottos {
        val manualCount = readManualCount()

        LottoGamePrinter.printManualNumbersMessage()
        val lottos = (1..manualCount).map {
            Lotto(LottoNumbers(readLottoNumbers()))
        }

        return ManualLottos(lottos)
    }

    private fun readLottoNumbers(): Set<LottoNumber> {
        return ConsoleReader.readLine()
            .split(",")
            .map { str -> convertToNumber(str) }
            .map { number -> LottoNumber(number) }
            .toSet()
    }

    private fun readManualCount(): Int {
        LottoGamePrinter.printManualCountMessage()
        val str = ConsoleReader.readLine()
        return convertToNumber(str)
    }

    private fun convertToNumber(str: String): Int {
        val number = str.trim().toIntOrNull()
        requireNotNull(number) { "숫자만 입력해야 합니다. 현재 입력=$str" }
        return number
    }
}
