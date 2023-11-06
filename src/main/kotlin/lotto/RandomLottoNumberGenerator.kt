package lotto

import kotlin.random.Random

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER + 1)
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
