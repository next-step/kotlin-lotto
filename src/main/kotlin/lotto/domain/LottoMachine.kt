package lotto.domain

import lotto.domain.generator.Generator
import java.util.stream.IntStream
import kotlin.streams.toList

class LottoMachine(private val generator: Generator) {

    fun issue(amount: Amount, manuals: List<String>): LottoIssueResult {
        val manualLottos = issue(manuals)
        val autoLottos = issue(amount.sub(Amount(LOTTO_PRICE * manuals.size)))
        return LottoIssueResult(manualLottos, autoLottos)
    }

    fun issue(amount: Amount): List<Lotto> {
        val count = amount.divide(LOTTO_PRICE)
        return IntStream.rangeClosed(1, count)
            .mapToObj { createLotto() }
            .toList()
    }

    fun issue(manuals: List<String>): List<Lotto> {
        val lottos = mutableListOf<Lotto>()

        for(manual in manuals) {
            lottos.add(createLotto(manual))
        }
        return lottos
    }

    private fun createLotto(manual: String): Lotto {
        val splitManual = manual.split(", ")
        return Lotto(splitManual.map { s -> s.toIntOrNull() ?: throw IllegalArgumentException() }.toList())
    }

    private fun createLotto(): Lotto {
        val numbers = generator.generate()
        return Lotto(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }

}