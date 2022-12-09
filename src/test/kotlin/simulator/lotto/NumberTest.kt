package simulator.lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class NumberTest {
    @Test
    fun `번호가 1 미만의 값이 있을 경우 Exception을 발생시킨다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Number(0) }
    }

    @Test
    fun `번호가 45 초과의 값이 있을 경우 Exception을 발생시킨다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Number(46) }
    }
}