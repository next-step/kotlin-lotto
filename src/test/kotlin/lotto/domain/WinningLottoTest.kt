package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WinningLottoTest {

    @Test
    fun `증복된 숫자로 우승 로또를 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(6))
        }
    }

    @Test
    fun `꽝 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 7, 8, 9, 10), LottoNumber(11))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.NOTHING)
    }

    @Test
    fun `5등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 7, 8, 9), LottoNumber(10))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `4등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 8, 9), LottoNumber(10))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `3등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 7), LottoNumber(8))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `2등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 7), LottoNumber(6))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `1등 로또 판정`() {
        val sut = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(7))

        val actual = sut.judge(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(Rank.FIRST)
    }
}
