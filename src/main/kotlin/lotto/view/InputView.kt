import lotto.domain.LottoConstants
import lotto.dto.LottoTicketNumbers
import lotto.dto.PurchaseAmount

object InputView {

    fun requestAmount(): PurchaseAmount {
        println("구입금액을 입력해 주세요.")
        return generateSequence {
            readlnOrNull()?.toIntOrNull()?.takeIf { it > 0 }?.let { PurchaseAmount(it) }
        }.firstOrNull() ?: run {
            println("유효하지 않은 금액입니다. 다시 입력해 주세요.")
            return requestAmount()
        }
    }

    fun requestManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return generateSequence {
            readlnOrNull()?.toIntOrNull()?.takeIf { it >= 0 }
        }.firstOrNull() ?: run {
            println("옳바르지 않은 입력입니다. 다시 입력해 주세요.")
            return requestManualTicketCount()
        }
    }

    fun requestManualNumbers(ticketCount: Int): List<LottoTicketNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..ticketCount).map {
            readValidLottoTicketNumbers()
        }
    }

    private fun readValidLottoTicketNumbers(): LottoTicketNumbers {
        return generateSequence {
            readlnOrNull()?.takeIf { isValidLottoNumbers(it) }?.let {
                val numbers = it.split(",").mapNotNull { number -> number.trim().toIntOrNull() }.sorted()
                LottoTicketNumbers(numbers)
            }
        }.firstOrNull() ?: run {
            println("유효하지 않은 입력입니다. 다시 입력해 주세요.")
            return readValidLottoTicketNumbers()
        }
    }

    private fun isValidLottoNumbers(input: String): Boolean {
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        return numbers.size == LottoConstants.NUMBERS_PER_TICKET &&
            numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }
    }

    fun requestWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return generateSequence {
            readlnOrNull()?.toWinningNumberSetOrNull()
        }.firstOrNull() ?: run {
            println("옳바르지 않은 입력입니다. 다시 입력해 주세요.")
            return requestWinningNumbers()
        }
    }

    fun requestBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return generateSequence {
            readlnOrNull()?.toIntOrNull()?.takeIf { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }
        }.firstOrNull() ?: run {
            println("옳바르지 않은 입력입니다. 다시 입력해 주세요.")
            return requestBonusBall()
        }
    }

    private fun String.toWinningNumberSetOrNull(): Set<Int>? {
        return this.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
            .takeIf { it.size == 6 && it.all { number -> number in 1..45 } }
    }
}
