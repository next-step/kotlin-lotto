package lotto.util

import kotlin.random.Random

object LottoNumberGenerator : NumberGenerator {

    private const val MIN = 1
    private const val MAX = 45

    override fun generate(): Int {
        return Random.nextInt(MIN, MAX + 1)
    }
}
