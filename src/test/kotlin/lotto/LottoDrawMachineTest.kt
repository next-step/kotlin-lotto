package lotto

import org.junit.jupiter.api.Test

class LottoDrawMachineTest {
    @Test
    fun `추출할 번호들을 입력받을 수 있다`() {
        LottoDrawMachine(1..45)
    }

    class LottoDrawMachine(pool: Set<Int>) {
        constructor(range: IntRange) : this(range.toSet())
    }
}
