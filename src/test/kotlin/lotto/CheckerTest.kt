package lotto

import org.assertj.core.api.Assertions.assertThat
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

    @CsvSource(
        value = [
            "1,2,2,6,9,13",
            "1,2,1,6,9,6",
            "1,2,3,3,3,6",
        ]
    )
    @ParameterizedTest
    fun `지난당첨번호는 중복 숫자를 허용하지 않는다`(lastNumber: String) {
        assertThrows<RuntimeException> { Checker(lastNumber) }
    }
    @CsvSource(
        value = [
            "'1,2,3,4,5,6', '1,2,3,4,5,6', 6",
            "'1,2,3,4,5,7', '1,2,3,4,5,6', 5",
            "'1,2,3,4,8,7', '1,2,3,4,5,6', 4",
            "'1,2,3,9,8,7', '1,2,3,4,5,6', 3",
            "'1,2,10,9,8,7', '1,2,3,4,5,6', 2",
            "'1,11,10,9,8,7', '1,2,3,4,5,6', 1",
            "'12,11,10,9,8,7', '1,2,3,4,5,6', 0",
        ]
    )
    @ParameterizedTest
    fun `지난당첨번호와 일치하는 개수를 확인한다`(lastNumberText: String, numberText: String, matchCount: Int) {
        val checker = Checker(lastNumberText)
        val numbers = numberText.split(",").map { it.toInt() }
        assertThat(checker.match(numbers)).isEqualTo(matchCount)
    }
}
