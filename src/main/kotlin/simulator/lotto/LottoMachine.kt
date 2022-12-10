package simulator.lotto

class LottoMachine(private val generator: NumberGenerator) {
    fun create(times: Int): List<Numbers> {
        return List(times) {
            Numbers.of(generator.generate())
        }
    }
}