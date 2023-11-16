package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    constructor(tickets: Int) : this(List(tickets) { Lotto() })

    constructor(tickets: Int, manualNumbers: List<Set<Int>>) : this(
        manualNumbers.map { Lotto(it) }.toList() + List(tickets) { Lotto() },
    )
}
