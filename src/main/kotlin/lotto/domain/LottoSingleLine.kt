package lotto.domain

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()
private const val LOTTO_PICK_COUNT = 6

class LottoSingleLine {
    private val lottoNumbers = createLine()
    private lateinit var lottoResult: LottoResult

    fun getNumbers(): List<Int> = lottoNumbers

    fun getResult(): LottoResult = lottoResult

    fun checkPlace(result: List<Int>, bonusNumber: Int) {
        lottoResult = getPlace(result.filter { lottoNumbers.contains(it) }.size, lottoNumbers.contains(bonusNumber))
    }

    private fun createLine(): List<Int> {
        return LOTTO_NUMBERS.shuffled().take(LOTTO_PICK_COUNT).sorted()
    }
}
