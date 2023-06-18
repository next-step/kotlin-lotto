package lotto.domain.numberGenerator

class FixedNumberGenerator(private val fixedNumbers: List<Int>) : NumberGenerator {

    override fun generateNumbers(): List<Int> {
        return fixedNumbers
    }
}
