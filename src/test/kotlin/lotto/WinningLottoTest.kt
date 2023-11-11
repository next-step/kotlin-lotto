package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `5등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 7, 8, 9), 10)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.FIFTH)
    }

    @Test
    fun `4등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 8, 9), 10)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `2등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 7), 6)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.SECOND)
    }
}
