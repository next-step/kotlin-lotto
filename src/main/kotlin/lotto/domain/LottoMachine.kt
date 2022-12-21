package lotto.domain

import lotto.domain.generator.Generator
import java.util.stream.IntStream
import kotlin.streams.toList

class LottoMachine(private val generator: Generator) {

    fun issue(amount: Amount, manuals: List<String>): LottoIssueResult {
        val manualLottos = manualIssue(manuals)
        val autoLottos = autoIssue(amount.sub(Amount(LOTTO_PRICE * manuals.size)))
        return LottoIssueResult(manualLottos, autoLottos)
    }

    private fun autoIssue(amount: Amount): List<Lotto> {
        val count = amount.divide(LOTTO_PRICE)
        return IntStream.rangeClosed(1, count)
            .mapToObj { createLotto() }
            .toList()
    }

    private fun manualIssue(manuals: List<String>): List<Lotto> {
        return manuals.map { createLotto(it) }
    }

    private fun createLotto(manual: String): Lotto {
        return Lotto.create(manual)
    }

    private fun createLotto(): Lotto {
        val numbers = generator.generate()
        return Lotto(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }

}