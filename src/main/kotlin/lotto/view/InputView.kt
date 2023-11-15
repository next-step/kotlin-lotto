import lotto.domain.LottoConstants

object InputView {

    fun requestAmount(): Int {
        return readValidInt("구입금액을 입력해 주세요.") { it > 0 }
    }

    fun requestManualTicketCount(): Int {
        return readValidInt("수동으로 구매할 로또 수를 입력해 주세요.") { it >= 0 }
    }

    fun requestManualNumbers(ticketCount: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..ticketCount).map {
            readValidIntSet {
                it.size == LottoConstants.NUMBERS_PER_TICKET &&
                    it.all { number -> number in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }
            }.toList().sorted()
        }
    }

    fun requestWinningNumbers(): Set<Int> {
        return readValidIntSet("지난 주 당첨 번호를 입력해 주세요.") { it.size == 6 && it.all { number -> number in 1..45 } }
    }

    fun requestBonusBall(): Int {
        return readValidInt("보너스 볼을 입력해 주세요.") {
            it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END
        }
    }

    private fun readValidIntSet(predicate: (Set<Int>) -> Boolean): Set<Int> {
        return generateSequence { readlnOrNull()?.toWinningNumberSetOrNull() }
            .firstOrNull(predicate) ?: throw IllegalArgumentException("Invalid input")
    }

    private fun readValidInt(message: String, predicate: (Int) -> Boolean): Int {
        println(message)
        return generateSequence { readlnOrNull()?.toIntOrNull() }
            .firstOrNull(predicate) ?: throw IllegalArgumentException("Invalid input")
    }

    private fun readValidIntSet(message: String, predicate: (Set<Int>) -> Boolean): Set<Int> {
        println(message)
        return generateSequence { readlnOrNull()?.toWinningNumberSetOrNull() }
            .firstOrNull(predicate) ?: throw IllegalArgumentException("Invalid input")
    }

    private fun String.toWinningNumberSetOrNull(): Set<Int>? {
        return this.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
            .takeIf { it.size == 6 && it.all { number -> number in 1..45 } }
    }
}
