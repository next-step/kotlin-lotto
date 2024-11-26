package lotto.domain

import kotlin.random.Random
import kotlin.random.nextInt

class LottoGenerator(private val count: Int) {
    fun generate() : List<List<Int>> {
        return List(count) { generateSingleLotto() }
    }

    private fun generateSingleLotto(): List<Int> {
        return List(6) { Random.nextInt(1 .. 100)}
    }
}