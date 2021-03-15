package domain

object RandomNumbers {
    private const val MIN_INDEX = 0

    fun generate(min: Int, max: Int, size: Int): List<Int> {
        val numbers = (min..max).map { it }.shuffled().sorted()
        return numbers.subList(MIN_INDEX, size)
    }
}
