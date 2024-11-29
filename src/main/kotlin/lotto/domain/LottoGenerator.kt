package lotto.domain

import lotto.model.Lotto
import kotlin.random.Random

class LottoGenerator(private val lottoCount: Int) {
    private val randomNumbers = List(lottoCount) { Random.nextInt(1, 99) }

    fun generate(): List<Lotto> {
        return List(lottoCount) { generateSingleLotto() }
    }

    private fun generateSingleLotto(): Lotto {
        return Lotto(randomNumbers.shuffled().take(LOTTO_NUMBER_SIZE))
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
