package lottery.domain.lotto

class Lotto(
    var numbers: List<Int> = emptyList()
) {
    init {
        if (numbers.isNotEmpty()) {
            check(numbers.size == 6)
        } else {
            createNumbers()
        }
    }

    private fun createNumbers() {
        numbers = numberRange.shuffled().subList(0, LOTTO_SLOT).sorted()
    }

    override fun toString() = "Lotto:$numbers"

    companion object {
        private const val LOTTO_SLOT = 6
        private val numberRange = (1..45)
    }
}
