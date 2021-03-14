package caculator

import org.junit.jupiter.api.BeforeEach

internal class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }
}
