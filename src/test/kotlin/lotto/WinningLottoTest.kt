package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `꽝 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 7, 8, 9, 10), 11)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.NOTHING)
    }

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
    fun `3등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 7), 8)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `2등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 7), 6)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `1등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), 7)

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Prize.FIRST)
    }
}
