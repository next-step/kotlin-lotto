package lotto.model

class Lottos(val lottos: List<Lotto>) {
    constructor(count: Int) : this(createLottos(count))

    companion object {
        private fun createLottos(count: Int): List<Lotto> {
            return (1..count).map { Lotto(LottoNumberPool().getLottoNumbers()) }
        }
    }
}
