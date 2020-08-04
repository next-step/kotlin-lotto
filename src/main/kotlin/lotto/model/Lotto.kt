package lotto.model

class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == NUMBER_COUNT) {
            "6개의 숫자를 선택해주세요."
        }
    }

    fun convertPrize(targetNumbers: List<Int>): Prize {
        val matchCount = numbers.count { targetNumbers.contains(it) }
        return Prize.findByMatchCount(matchCount)
    }

    companion object {
        const val PRICE = 1_000
        const val NUMBER_COUNT = 6
        val NUMBER_GENERATION_RANGE = 1..45
    }
}
