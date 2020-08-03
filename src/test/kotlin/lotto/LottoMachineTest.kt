package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `리스트의 동일 숫자 개수 계산`() {
        val bases = LottoNumber(1, 2, 3, 4, 5, 6)
        val compares = LottoNumber(4, 5, 6, 7, 8, 9)

        val machine = LottoMachine()
        val count = machine.equalsCount(bases, compares)

        assertThat(count).isEqualTo(3)
    }
}
