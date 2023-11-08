import lotto.domain.LottoConstants

object InputView {
    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readValidInt { it > 0 }
    }

    fun getWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readValidIntSet { it.size == 6 && it.all { number -> number in 1..45 } }
    }

    fun getBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readValidInt { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }
    }

    private fun readValidInt(predicate: (Int) -> Boolean): Int {
        return generateSequence { readlnOrNull()?.toIntOrNull() }
            .first(predicate)
    }

    private fun readValidIntSet(predicate: (Set<Int>) -> Boolean): Set<Int> {
        return generateSequence { readlnOrNull()?.toWinningNumberSetOrNull() }
            .first(predicate)
    }

    private fun String.toWinningNumberSetOrNull(): Set<Int>? {
        return this.split(",").mapNotNull { it.trim().toIntOrNull() }
            .takeIf { it.size == 6 && it.all { number -> number in 1..45 } }?.toSet()
    }
}
