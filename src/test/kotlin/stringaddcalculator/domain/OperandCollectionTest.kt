package stringaddcalculator.domain

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
}
