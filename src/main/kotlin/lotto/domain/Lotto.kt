package lotto.domain

class Lotto {

    val numbers: List<Int> = initList()

    override fun toString(): String {
        return numbers.toString()
    }

    private fun initList(): List<Int> {
        return LOTTO_NUMBER_RANGE.shuffled().subList(START_LOTTO_INDEX, LAST_LOTTO_INDEX).sorted()
    }

    companion object {
        const val START_LOTTO_INDEX = 0
        const val LAST_LOTTO_INDEX = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
