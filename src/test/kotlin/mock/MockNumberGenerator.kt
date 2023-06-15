package mock

import util.NumberGenerator

class MockNumberGenerator(private val mockNumbers: List<Int>) : NumberGenerator {
    override fun randomNumberGenerator(): List<Int> {
        return mockNumbers
    }
}
