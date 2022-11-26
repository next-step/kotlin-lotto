package lotto

class LottoStore(private val generator: LottoGenerator = LottoGenerator()) {

    fun sell(money: Value): List<Lotto> {
        val numberOfLotto = money.money / 1000
        val lottos = mutableListOf<Lotto>()
        repeat(numberOfLotto) {
            lottos.add(generator.generate())
        }
        return lottos
    }
}
