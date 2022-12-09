package simulator.lotto

class Lotto(val number: Number) {
    override fun toString(): String {
        return number.values.joinToString(",")
    }

    companion object {
        const val PRICE = 1_000
    }
}
