package step2.lotto.service

interface LottoGenerator {
    fun generate(): List<Int>

    companion object {
        const val GENERATE_NUMBER_COUNT = 6
        const val RANGE_START = 1
        const val RANGE_END = 45
    }
}
