package lotto.domain

import kotlin.random.Random

data class LottoNumber(val number: Int) {
    constructor() : this(generateRandomNumber())

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private fun generateRandomNumber(): Int {
            return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
        }
    }

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            throw IllegalArgumentException("Number must be between $MIN_NUMBER and $MAX_NUMBER")
        }
    }
}
