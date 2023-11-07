package lotto.domain

import lotto.numbermaker.RandomNumberMaker

class Lottos(val lottoList: List<Lotto>) {
    constructor(tickets: Int) : this(List(tickets) { Lotto(RandomNumberMaker().generate()) })
}
