package lotto.view

class ConsoleInput {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")

        return readNonBlankLn().toIntOrNull() ?: throw IllegalArgumentException("purchase amount should be number")
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return readNonBlankLn().toIntOrNull() ?: throw IllegalArgumentException("count of manual lotto should be number")
    }

    fun getManualLottoNumbers(manualLottoCount: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..manualLottoCount)
            .map { readNonBlankLn().takeIf { it.contains(LOTTO_NUMBER_DELIMITER) } ?: throw IllegalArgumentException("lotto numbers should contain $LOTTO_NUMBER_DELIMITER") }
            .map { lottoNumbers -> lottoNumbers.split(LOTTO_NUMBER_DELIMITER).map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("each lotto number should be number") } }
    }

    fun getWinnerNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningNumbers = readNonBlankLn().takeIf { it.contains(LOTTO_NUMBER_DELIMITER) } ?: throw IllegalArgumentException("winning numbers should contain $LOTTO_NUMBER_DELIMITER")

        return winningNumbers.split(LOTTO_NUMBER_DELIMITER)
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("each winning number should be number") }
    }

    fun getBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readNonBlankLn().toIntOrNull() ?: throw IllegalArgumentException("bonus ball should be number")
    }

    private fun readNonBlankLn() = readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }

    companion object {
        private const val LOTTO_NUMBER_DELIMITER = ","
    }
}
