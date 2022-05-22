package calculator.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTests {
    private val out = ByteArrayOutputStream().also {
        System.setOut(PrintStream(it))
    }

    @Test
    fun `소수점 아래가 0 인경우에는 소수점을 제외하고 출력한다`() {
        OutputView().result(10.0)
        assertThat(out.toString()).isEqualTo("10\n")
    }

    @Test
    fun `소수점 아래 수자가 있는 경우에는 똑같이 출력한다`() {
        OutputView().result(10.1)
        assertThat(out.toString()).isEqualTo("10.1\n")
    }
}
