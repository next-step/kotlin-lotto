package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CheckerTest {
    @CsvSource(
        value = [
            "1",
            "1,2,6",
            "1,2,4,6",
            "1,2,4,6,9",
            "1,%,4,6,9",
            "1,%,4,^,9",
            "*",
        ]
    )
    @ParameterizedTest
    fun `지난당첨번호는 6개의 숫자이다`(lastNumber: String) {
        assertThrows<RuntimeException> { Checker(lastNumber) }
    }
}
