import lotto.domain.LottoConstants
import lotto.dto.LottoTicketNumbers
import lotto.dto.PurchaseAmount

object InputView {

    fun requestAmount(): PurchaseAmount {
        println("구입금액을 입력해 주세요.")
        return generateSequence { readlnOrNull()?.toIntOrNull() }
            .map { PurchaseAmount(it) }
            .firstOrNull() ?: throw IllegalArgumentException("유효하지 않은 금액입니다.")
    }

    fun requestManualTicketCount(): Int {
        return readValidInt("수동으로 구매할 로또 수를 입력해 주세요.") { it >= 0 }
    }

    fun requestManualNumbers(ticketCount: Int): List<LottoTicketNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..ticketCount).map {
            readValidLottoTicketNumbers()
        }
    }

    private fun readValidLottoTicketNumbers(): LottoTicketNumbers {
        while (true) {
            val input = readlnOrNull()
            if (input != null && isValidLottoNumbers(input)) {
                val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }.sorted()
                return LottoTicketNumbers(numbers)
            }
            println("유효하지 않은 입력입니다. 다시 입력해 주세요.")
        }
    }

    private fun isValidLottoNumbers(input: String): Boolean {
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        return numbers.size == LottoConstants.NUMBERS_PER_TICKET &&
            numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }
    }

    fun requestWinningNumbers(): Set<Int> {
        return readValidIntSet("지난 주 당첨 번호를 입력해 주세요.") { it.size == 6 && it.all { number -> number in 1..45 } }
    }

    fun requestBonusBall(): Int {
        return readValidInt("보너스 볼을 입력해 주세요.") {
            it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END
        }
    }

    private fun readValidInt(message: String, predicate: (Int) -> Boolean): Int {
        println(message)
        return generateSequence { readlnOrNull()?.toIntOrNull() }
            .firstOrNull(predicate) ?: throw IllegalArgumentException("옳바르지 않은 입력입니다.")
    }

    private fun readValidIntSet(message: String, predicate: (Set<Int>) -> Boolean): Set<Int> {
        println(message)
        return generateSequence { readlnOrNull()?.toWinningNumberSetOrNull() }
            .firstOrNull(predicate) ?: throw IllegalArgumentException("옳바르지 않은 입력입니다.")
    }

    private fun String.toWinningNumberSetOrNull(): Set<Int>? {
        return this.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
            .takeIf { it.size == 6 && it.all { number -> number in 1..45 } }
    }
}
