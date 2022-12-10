package lotto.domain

import lotto.domain.generator.Generator
import java.util.stream.IntStream
import kotlin.streams.toList

class LottoMachine(private val generator: Generator) {

    fun issue(amount: Amount): List<Lotto> {
        val count = amount.divide(LOTTO_PRICE)
        return issue(count)
    }

    fun issue(count: Int): List<Lotto> {
        return IntStream.rangeClosed(1, count)
            .mapToObj { createLotto() }
            .toList()
    }

    private fun createLotto(): Lotto {
        val numbers = generator.generate()
        return Lotto(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }

}