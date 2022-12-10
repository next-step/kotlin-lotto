package step2.lotto.service

interface LottoGenerator {
    fun generate(): Set<Int>

    companion object {
        const val LOTTO_SIZE = 6
        const val RANGE_START = 1
        const val RANGE_END = 45
    }
}
