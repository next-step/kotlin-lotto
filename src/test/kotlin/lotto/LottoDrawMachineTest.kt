package lotto

import org.junit.jupiter.api.Test

class LottoDrawMachineTest {
    @Test
    fun `추출할 번호들을 입력받을 수 있다`() {
        LottoDrawMachine(1..45)
    }

    @Test
    fun `번호는 45개여야 한다`() {
        assertThat(LottoDrawMachine(1..45).size).isEqualTo(45)
    }

    class LottoDrawMachine(pool: Set<Int>) {
        constructor(range: IntRange) : this(range.toSet())
    }
}
