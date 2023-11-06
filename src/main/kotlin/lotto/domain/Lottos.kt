package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    constructor (amount: Int) : this(generateLottoList(amount))

    companion object {
        private fun generateLottoList(amount: Int) = (1..amount).map { Lotto() }
    }
}
