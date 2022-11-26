package lotto

import java.security.SecureRandom

class Lotto(val price: Int) {

    init {
        require(price % BASE_PRICE == 0) { "input incorrectly price" }
    }

    fun createNumbers(): List<Int> {
        val randomNumbers = ArrayList<Int>()

        (0 until NUMBERS_COUNT).map { addRandomNumber(randomNumbers) }

        return randomNumbers
    }

    private fun addRandomNumber(randomNumbers: ArrayList<Int>) {
        var randomNumber: Int

        do {
            randomNumber = SecureRandom.getInstanceStrong().nextInt(MAX_RANDOM_VALUE)
        } while (randomNumbers.contains(randomNumber))

        randomNumbers.add(randomNumber)
    }

    companion object {
        private const val BASE_PRICE = 1000
        private const val NUMBERS_COUNT = 6
        private const val MAX_RANDOM_VALUE = 45
    }
}
