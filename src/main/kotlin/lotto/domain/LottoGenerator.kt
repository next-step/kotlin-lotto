package lotto.domain

import lotto.model.Lotto
import kotlin.random.Random
import kotlin.random.nextInt

class LottoGenerator(private val count: Int) {
    fun generate(): List<Lotto> {
        return List(count) { generateSingleLotto() }
    }

    private fun generateSingleLotto(): Lotto {
        return Lotto(List(LOTTO_NUMBER_SIZE) { Random.nextInt(1..99) })
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
