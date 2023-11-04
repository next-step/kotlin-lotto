package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class OperandTest{

    @Test
    fun `피연산자를 가져온다`() {
        val operand = Operand("1")
        assertEquals(operand.getValue(), 1)
    }

    @Test
    fun `피연산자에 음수가 오면 에러를 반환한다`() {
        assertThrows(RuntimeException::class.java) {
            Operand("-1")
        }
    }

    @Test
    fun `피연산자에 숫자가 아닌 값이 오면 에러를 반환한다`() {
        assertThrows(RuntimeException::class.java) {
            Operand("a")
        }
    }
}
