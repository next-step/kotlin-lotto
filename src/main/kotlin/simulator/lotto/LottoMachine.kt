package simulator.lotto

class LottoMachine(private val generator: NumberGenerator) {
    fun create(times: Int): Lottos {
        return Lottos(List(times) {
            Lotto(generator.generate().toSet())
        })
    }
}