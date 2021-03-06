package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoDrawMachineTest {
    @Test
    fun `추출할 번호들을 입력받을 수 있다`() {
        LottoDrawMachine(1..45)
    }

    @Test
    fun `번호는 45개이다`() {
        assertThat(LottoDrawMachine(1..45).size).isEqualTo(45)
    }

    class LottoDrawMachine(pool: Set<Int>) {
        val size: Int = pool.size

        constructor(range: IntRange) : this(range.toSet())
    }
}
