package lotto.domain

class RandomSetGenerator {
    fun getRandomNumbers(): List<Int> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled().subList(0, NUMBER_OF_NUMBER)
    }

    companion object {
        const val NUMBER_OF_NUMBER = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
    }
}
