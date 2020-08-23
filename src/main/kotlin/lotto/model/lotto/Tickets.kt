package lotto.model.lotto

import lotto.model.generator.ManualNumberGenerator

class Tickets(
    private val numbersList: List<Numbers> = emptyList()
) {
    val size
        get() = numbersList.size

    fun toLottos() = numbersList.map { Lotto.newInstance(ManualNumberGenerator(it)) }
}
