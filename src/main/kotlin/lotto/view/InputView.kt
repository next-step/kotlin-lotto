package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.PurchaseMoney
import lotto.domain.toLottoNumber
import lotto.domain.toPurchaseMoney

class InputView(private val reader: () -> String?, private val writer: (String) -> Unit) {

    fun readPurchaseMoney(): PurchaseMoney {
        var purchaseMoney: PurchaseMoney? = null
        while (purchaseMoney == null) {
            printInputPurchaseMoney()

            purchaseMoney = kotlin
                .runCatching { reader()?.toInt()?.toPurchaseMoney() }
                .getOrNull()
        }
        return purchaseMoney
    }

    private fun printInputPurchaseMoney() {
        writeLine("구입금액을 입력해 주세요.")
    }

    fun readCountOfManualLotto(): Int {
        var countOfManual: Int? = null
        while (countOfManual == null) {
            printInputCountOfManualLotto()

            val value = reader()
            countOfManual = kotlin
                .runCatching { value?.toInt() }
                .getOrNull()
        }
        return countOfManual
    }

    private fun printInputCountOfManualLotto() {
        writeLine("\n수동으로 구매할 로또 수를 입력해 주세요.")
    }

    fun readManualLottoTicket(size: Int): List<LottoTicket> {
        printInputManualLottoNumbers()

        val manualLottoNumbers = mutableListOf<LottoTicket>()
        while (manualLottoNumbers.size < size) {
            kotlin
                .runCatching { LottoTicket.ManualLottoTicket(readLottoNumber()) }
                .onSuccess { manualLottoNumbers.add(it) }
                .onFailure { printInputLottoNumberAgain() }
        }
        return manualLottoNumbers
    }

    private fun printInputManualLottoNumbers() {
        writeLine("\n수동으로 구매할 번호를 입력해 주세요.")
    }

    fun readLastLottoTicket(): LottoTicket.LastLottoTicket {
        printInputLastLottoNumbers()

        var lastLottoTicket: LottoTicket.LastLottoTicket? = null
        while (lastLottoTicket == null) {
            lastLottoTicket = kotlin
                .runCatching { LottoTicket.LastLottoTicket(readLottoNumber()) }
                .getOrElse {
                    printInputLottoNumberAgain()
                    null
                }
        }
        return lastLottoTicket
    }

    private fun printInputLastLottoNumbers() {
        writeLine("\n지난 주 당첨 번호를 입력해 주세요.")
    }

    private fun readLottoNumber(): Set<LottoNumber> {
        var lottoNumbers: Set<LottoNumber>? = null
        while (lottoNumbers == null) {
            val value = reader()
            lottoNumbers = kotlin
                .runCatching { value?.tokenize()?.toInt()?.toSet()?.toLottoNumber() }
                .getOrElse {
                    printInputLottoNumberAgain()
                    null
                }
        }
        return lottoNumbers
    }

    private fun printInputLottoNumberAgain() {
        writeLine("6자리 번호를 다시 입력해주세요.")
    }

    fun readBonusLottoNumber(): LottoNumber {
        var bonusLottoNumber: LottoNumber? = null
        while (bonusLottoNumber == null) {
            printInputBonusLottoNumber()
            val value = reader()
            bonusLottoNumber = kotlin
                .runCatching { value?.toInt()?.toLottoNumber() }
                .getOrNull()
        }
        return bonusLottoNumber
    }

    private fun printInputBonusLottoNumber() {
        writeLine("보너스 볼을 입력해 주세요.")
    }

    private fun writeLine(message: String) = writer("$message\n")

    private fun String.tokenize(): List<String> =
        split(DELIMITER)
            .map { it.trim() }
            .filter { it.isNotBlank() }

    private fun List<String>.toInt() =
        kotlin.runCatching { map { it.toInt() } }.getOrIllegalArgumentException()

    private fun <R, T : R> Result<T>.getOrIllegalArgumentException(): R =
        getOrElse { throw IllegalArgumentException(it.message) }

    companion object {
        private const val DELIMITER = ","
    }
}
