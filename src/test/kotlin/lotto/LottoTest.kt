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
    fun `로또 번호 3개 일치`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 7, 8, 9))

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `로또 번호 4개 일치`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 8, 9))

        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `로또 번호 5개 일치`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 5, 9))

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `로또 번호 6개 일치`() {
        val sut = Lotto(1, 2, 3, 4, 5, 6)

        val actual = sut.matchedCount(Lotto(1, 2, 3, 4, 5, 6))

        assertThat(actual).isEqualTo(6)
    }
}
