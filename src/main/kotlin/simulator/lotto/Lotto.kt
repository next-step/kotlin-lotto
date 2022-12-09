package simulator.lotto

class Lotto(val numbers: Numbers) {
    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val PRICE = 1_000
    }
}
