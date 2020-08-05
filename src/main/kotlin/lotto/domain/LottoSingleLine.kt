package lotto.domain

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()
private const val LOTTO_PICK_COUNT = 6

class LottoSingleLine(numbers: List<Int> = emptyList()) {
    val manual = numbers.isNotEmpty()
    var lottoNumbers = if (manual) numbers else createLine()
    private lateinit var lottoResult: LottoResult

    fun getResult(): LottoResult = lottoResult

    fun checkPlace(result: List<Int>, bonusNumber: Int) {
        lottoResult = getPlace(result.filter { lottoNumbers.contains(it) }.size, lottoNumbers.contains(bonusNumber))
    }

    private fun createLine(): List<Int> {
        return LOTTO_NUMBERS.shuffled().take(LOTTO_PICK_COUNT).sorted()
    }
}
