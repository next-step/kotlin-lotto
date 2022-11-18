package domain

class Numbers(private val numbers: List<Int> = listOf()) {
    fun sum(): Int {
        return if (this.numbers.size == ZERO) {
            ZERO
        } else {
            numbers.sum()
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
