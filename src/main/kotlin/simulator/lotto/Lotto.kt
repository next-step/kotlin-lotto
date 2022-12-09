package simulator.lotto

class Lotto(val numbers: Numbers) {
    override fun toString(): String {
        return numbers.values.joinToString(",")
    }

    companion object {
        const val PRICE = 1_000
    }
}
