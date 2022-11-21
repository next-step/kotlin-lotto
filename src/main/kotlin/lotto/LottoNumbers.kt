package lotto

object LottoNumbers {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45

    private val numbers: List<Int> = (MIN_NUMBER..MAX_NUMBER).toList()

    fun getNumbers() = numbers

    fun pick(): List<Int> {
        return numbers.shuffled().subList(0, 6)
    }
}
