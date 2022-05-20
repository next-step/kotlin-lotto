package calculator

class PlusCalculator(private val numbers: PositiveNumbers) {

    fun calculate(): PositiveNumber = numbers.add()
}
