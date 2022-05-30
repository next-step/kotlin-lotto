package lotto.domain

class LottoNumber(private val seeds: List<Int>? = null) {
    val numbers: MutableSet<Int>

    init {
        if (seeds != null) {
            validate(seeds)
        }

        numbers = (seeds ?: LOTTO_NUMBER_RANGE)
            .toMutableList()
            .shuffled()
            .subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX)
            .sorted()
            .toMutableSet()
    }

    fun addBonusNumber(number: Int) {
        numbers.add(number)
    }

    private fun validate(numbers: List<Int>) {
        require(numbers.size >= LOTTO_NUMBER_SIZE) { "로또 번호는 최소 6자 입니다." }
        numbers.forEach { require(it in LOTTO_NUMBER_RANGE) { "로또 번호가 유효 범위내에 있지 않습니다." } }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        private const val MIN_LOTTO_INDEX = 0
        private const val MAX_LOTTO_INDEX = 6
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
