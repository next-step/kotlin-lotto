package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

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
