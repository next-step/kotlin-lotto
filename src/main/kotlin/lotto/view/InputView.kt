package lotto.view

class InputView(private val reader: () -> String?, private val writer: (String) -> Unit) {

    fun readPurchaseMoney(): Int {
        printInputPurchaseMoney()

        val value = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        return kotlin
            .runCatching { value.toInt() }
            .getOrIllegalArgumentException()
    }

    private fun printInputPurchaseMoney() {
        writeLine("구입금액을 입력해 주세요.")
    }

    fun readLastLottoNumbers(): Set<Int> {
        printInputLastLottoNumbers()

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
