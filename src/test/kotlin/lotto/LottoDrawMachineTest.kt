package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoDrawMachineTest {
    @Test
    fun `번호는 45개이다`() {
        assertThat(LottoDrawMachine(1..45).size).isEqualTo(45)
    }

    @Test
    fun `45개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoDrawMachine((1..44).toSet() + setOf(1)) }
    }

    @Test
    fun `로또 번호를 생성한다`() {
        LottoDrawMachine(1..45).lottoNumber()
    }

    @Test
    fun `로또 번호는 6개 이다`() {
        assertAll(
            {
                LottoNumbers((1..6))
            },
            {
                assertThrows<IllegalArgumentException> { LottoNumbers((1..5)) }
            },
            {
                assertThrows<IllegalArgumentException> { LottoNumbers((1..7)) }
            }
        )
    }
}
