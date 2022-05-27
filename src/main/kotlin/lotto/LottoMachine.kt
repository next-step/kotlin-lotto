package lotto

class LottoMachine(private val lottoMaker: LottoMaker) {

    fun buyLotto(count: Int): Lottos {
        val lottos = mutableListOf<Lotto>()
        repeat(count) {
            lottos.add(lottoMaker.make())
        }

        return Lottos(lottos)
    }
}
