package lotto.domain

class LottoTicket(private val seeds: List<Int>) {
    init {
        validate(seeds)
    }

    val numbers: List<Int>
        get() = seeds.subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX).sorted()

    private fun validate(seeds: List<Int>) {
        require(seeds.size >= LOTTO_NUMBER_SIZE)
        seeds.forEach { require(it in LOTTO_NUMBER_RANGE) }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        private const val MIN_LOTTO_INDEX = 0
        private const val MAX_LOTTO_INDEX = 6
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
