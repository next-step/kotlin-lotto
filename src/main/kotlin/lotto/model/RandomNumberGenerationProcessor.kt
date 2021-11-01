package lotto.model

/**
 * 랜덤 숫자 반환하는 클래스
 * */
object RandomNumberGenerationProcessor {
    private const val NUMBER_START = 0
    private const val NUMBER_END = 6

    fun generateNumbers(range: List<Int>): List<Int> {
        require(range.size > 6)
        return (range)
            .shuffled()
            .subList(NUMBER_START, NUMBER_END)
    }
}
