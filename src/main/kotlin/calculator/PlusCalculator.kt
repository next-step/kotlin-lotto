package calculator

class PlusCalculator(private val numbers: PositiveNumbers) {

    fun calculate(): PositiveNumber {
        return numbers.add()
    }
}
