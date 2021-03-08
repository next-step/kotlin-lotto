package stringaddcalculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperandCollectionTest {
    @Test
    @DisplayName("들어온 문자열 리스트에 대한 합 연산이 가능하다")
    internal fun factoryMethodWithStringList() {
        val stringList = listOf("1", "2", "3")
        val resultNumber = OperandCollection.of(stringList).plusAllNumbers()
        assertThat(resultNumber).isEqualTo(Operand(6))
    }

    @Test
    @DisplayName("문자열 리스트의 개수가 1개일 때 해당 숫자를 반환한다")
    internal fun singleNumberCalculate() {
        val stringList = listOf("10")
        val resultNumber = OperandCollection.of(stringList).plusAllNumbers()
        assertThat(resultNumber).isEqualTo(Operand(10))
    }

    @Test
    @DisplayName("문자열 리스트의 개수가 0개일 때 0을 반환한다")
    internal fun blankNumberCalculate() {
        val stringList = arrayListOf<String>()
        val resultNumber = OperandCollection.of(stringList).plusAllNumbers()
        assertThat(resultNumber).isEqualTo(Operand(0))
    }

    @Test
    @DisplayName("문자열 리스트에 음수가 있을 떄 예외가 발생한다")
    internal fun negativeNumberCalculate() {
        val stringList = arrayListOf("1", "-10", "5")
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { OperandCollection.of(stringList).plusAllNumbers() }
    }
}
