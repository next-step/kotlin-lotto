package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = [5, 7])
    fun `잘못된 숫자 갯수로 로또 생성 시 예외 발생`(size: Int) {
        assertThrows<IllegalArgumentException> {
            val numbers = (0 until size).toList().toIntArray()
            Lotto(*numbers)
        }
    }

    @Test
    fun `중복된 숫자로 로또 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(1, 2, 3, 4, 5, 1)
        }
    }

    @Test
    fun `5등 로또 판정`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 7, 8, 9))

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `4등 로또 판정`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 8, 9))

        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `3등 로또 판정`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 5, 9))

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `2등 로또 판정`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.judge(WinningLotto(Lotto(1, 2, 3, 4, 5, 7), 6))

        assertThat(actual).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `1등 로또 판정`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(6)
    }
}
