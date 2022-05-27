package lotto.generator

object NumbersGenerator {
    private val LOTTO_RANGE = 1..45

    fun create(): List<Int> {
        return LOTTO_RANGE.toMutableList().shuffled()
    }
}
