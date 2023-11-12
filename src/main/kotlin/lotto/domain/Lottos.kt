package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    constructor(tickets: Int) : this(List(tickets) { Lotto() })
}
