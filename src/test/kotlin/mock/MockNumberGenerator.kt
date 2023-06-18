package mock

import util.NumberGenerator

class MockNumberGenerator(private val mockNumbers: Set<Int>) : NumberGenerator {
    override fun randomNumbers(): Set<Int> {
        return mockNumbers
    }
}
