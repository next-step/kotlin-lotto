package lotto.domain

import lotto.domain.generator.Generator
import java.util.stream.IntStream
import kotlin.streams.toList

class LottoMachine(private val generator: Generator) {

    fun issue(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE

        return IntStream.rangeClosed(1, count)
            .mapToObj { createLotto() }
            .toList()
    }

    private fun createLotto(): Lotto {
        val numbers = generator.generate()
        return Lotto(numbers)
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }

}