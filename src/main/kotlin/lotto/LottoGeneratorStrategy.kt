package lotto

interface LottoGeneratorStrategy {
    fun generate(count: Int): List<LottoNumbers>

    private val firstNumber: Int
        get() = 1
    private val lastNumber: Int
        get() = 45
    val totalNumbers
        get() = (firstNumber..lastNumber).toList().shuffled()
}
