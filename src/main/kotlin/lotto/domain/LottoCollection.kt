package lotto.domain

class LottoCollection(private val _lotto: MutableList<Lotto> = mutableListOf()) {
    val lotto: List<Lotto>
        get() = _lotto

    constructor(count: Int, _generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this() {
        require(count >= 1)

        repeat(count) {
            _lotto.add(Lotto(_generator))
        }
    }
}
