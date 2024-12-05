package lotto.util

class RandomNumberGenerator(
    from: Int = 1,
    until: Int = 45,
) : NumberGenerator {
    private val randomNumbers = (from..until).toList()

    override fun getNumbers(count: Int): List<Int> {
        return randomNumbers.shuffled().take(count)
    }
}
