package simulator.lotto

class LottoMachine(private val generator: NumberGenerator) {
    fun create(times: Int): List<Lotto> {
        return List(times) {
            Lotto(generator.generate())
        }
    }
}