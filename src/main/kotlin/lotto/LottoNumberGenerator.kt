package lotto

object LottoNumberGenerator {
    private const val FIRST_NUMBER = 1
    private const val LAST_NUMBER = 45

    private val totalNumbers = (FIRST_NUMBER..LAST_NUMBER).toList()

    fun generate(count: Int): List<LottoNumbers> {
        return (1..count).map { generateLottoNumber() }
    }
    private fun generateLottoNumber(): LottoNumbers {
        return LottoNumbers(totalNumbers.shuffled().slice(0 until 6).sorted())
    }
}
