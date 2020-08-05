package stringcalculatortest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

import stringcalculator.Inputformular
import stringcalculator.Operation
import java.lang.IllegalArgumentException

class TestCalculator {

    @Test
    @DisplayName("연산자 테스트")
    fun `operatetest`() {
        assertAll(
            { assertThat(Operation.run("+").cal(3, 4)).isEqualTo(7) },
            { assertThat(Operation.run("-").cal(4, 3)).isEqualTo(1) },
            { assertThat(Operation.run("*").cal(4, 5)).isEqualTo(20) },
            { assertThat(Operation.run("/").cal(5, 5)).isEqualTo(1) }
        )
    }

    @Test
    @DisplayName("문자 분리 테스트")
    fun `inputtest`() {
        assertAll(
            { assertThat(Inputformular().stol("2 + 4 - 1 * 5")).isEqualTo(listOf("2", "+", "4", "-", "1", "*", "5")) },
            { assertThrows<IllegalArgumentException> { (Inputformular().stol(" ")) } },
            { assertThrows<IllegalArgumentException> { (Inputformular().stol(null)) } }
        )
    }
}
