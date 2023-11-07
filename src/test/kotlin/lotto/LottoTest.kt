package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 1개 생성`() {
        val sut = LottoMachine()

        val actual = sut.create()

        assertThat(actual).hasSize(1)
    }

    @Test
    fun `입력 금액 만큼 로또 생성`() {
        val sut = LottoMachine()

        val actual = sut.create(13000)

        assertThat(actual).hasSize(13)
    }
}
