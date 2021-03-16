package lotto.domain

class LottoCollection(private val _lotto: MutableList<Lotto> = mutableListOf(), private val generator: LottoNumberGenerator = LottoNumberRandomGenerator()) {
    val lotto: List<Lotto>
        get() = _lotto
    constructor(count: Int, _generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(generator = _generator) {
        require(count >= 1)

        repeat(count) {
            _lotto.add(Lotto(generator))
        }
    }
}
