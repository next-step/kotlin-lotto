package lotto

import java.security.SecureRandom

class Lotto(val price: Int) {

    init {
        require(price % BASE_PRICE == 0) { "input incorrectly price" }
    }

    fun createNumbers(): List<Int> = (0 until NUMBERS_COUNT).map { createRandomNumbers() }

    private fun createRandomNumbers(): Int = SecureRandom.getInstanceStrong().nextInt(MAX_RANDOM_VALUE)

    companion object {
        private const val BASE_PRICE = 1000
        private const val NUMBERS_COUNT = 6
        private const val MAX_RANDOM_VALUE = 45
    }
}
