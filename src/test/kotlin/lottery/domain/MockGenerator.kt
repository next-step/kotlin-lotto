package lottery.domain

class MockGenerator() : NumbersGenerator {
    private var numbers: List<Int> = listOf()

    constructor(numbers: List<Int>) : this() {
        this.numbers = numbers
    }

    override fun generate(min: Int, max: Int, size: Int): List<Int> {
        return this.numbers
    }
}
