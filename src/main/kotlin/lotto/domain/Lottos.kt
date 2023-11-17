package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    constructor(tickets: Int, manualNumbers: List<Set<Int>> = NO_MANUAL_NUMBERS) : this(
        manualNumbers.map { Lotto(it) }.toList() + List(tickets) { Lotto() },
    )

    companion object {
        private val NO_MANUAL_NUMBERS: List<Set<Int>> = emptyList()
    }
}
