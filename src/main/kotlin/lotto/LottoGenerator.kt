package lotto

class LottoGenerator(private val count: Int, private val minNumber: Int, private val maxNumber: Int) {
    fun generate(generatable: Generatable): Lotto {
        return generatable.generate(count, minNumber, maxNumber)
    }
}
