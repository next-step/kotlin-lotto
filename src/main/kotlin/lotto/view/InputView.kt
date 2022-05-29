package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.PurchaseMoney
import lotto.domain.toLottoNumber
import lotto.domain.toPurchaseMoney

class InputView(private val reader: () -> String?, private val writer: (String) -> Unit) {

    fun readPurchaseMoney(): PurchaseMoney {
        printInputPurchaseMoney()

        val value = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        return kotlin
            .runCatching { value.toInt().toPurchaseMoney() }
            .getOrIllegalArgumentException()
    }

    private fun printInputPurchaseMoney() {
        writeLine("구입금액을 입력해 주세요.")
    }

    fun readCountOfManualLotto(): Int {
        printInputCountOfManualLotto()

        val value = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        return kotlin
            .runCatching { value.toInt() }
            .getOrIllegalArgumentException()
    }

    private fun printInputCountOfManualLotto() {
        writeLine("\n수동으로 구매할 로또 수를 입력해 주세요.")
    }

    fun readManualLottoTicket(size: Int): List<LottoTicket> {
        printInputManualLottoNumbers()

        val manualLottoNumbers = mutableListOf<LottoTicket>()
        repeat(size) {
            manualLottoNumbers.add(
                LottoTicket.ManualLottoTicket(
                    readLottoNumber().toLottoNumber()
                )
            )
        }
        return manualLottoNumbers
    }

    private fun printInputManualLottoNumbers() {
        writeLine("\n수동으로 구매할 번호를 입력해 주세요.")
    }

    fun readLastLottoTicket(): LottoTicket.LastLottoTicket {
        printInputLastLottoNumbers()

        return LottoTicket.LastLottoTicket(
            readLottoNumber().toLottoNumber()
        )
    }

    private fun readLottoNumber(): Set<Int> {
        val value = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        return value
            .tokenize()
            .toInt()
            .toSet()
    }

    private fun printInputLastLottoNumbers() {
        writeLine("\n지난 주 당첨 번호를 입력해 주세요.")
    }

    fun readBonusLottoNumber(): Int {
        printInputBonusLottoNumber()

        val value = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        return runCatching { value.toInt() }.getOrIllegalArgumentException()
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
