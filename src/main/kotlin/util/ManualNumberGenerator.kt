package util

class ManualNumberGenerator(private val numbers: Set<Int>) : NumberGenerator {
    override fun randomNumbers(): Set<Int> {
        return numbers
    }
}
