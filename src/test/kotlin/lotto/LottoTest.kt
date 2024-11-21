package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `1-45 범위를 벗어나면 예외발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            Lotto.from(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `6개가 아니면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Lotto.from(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `중복된 숫자를 가질 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Lotto.from(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `일치갯수 확인`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto.from(listOf(1, 2, 3, 4, 5, 7))

        val actual = lotto.match(otherLotto)

        assertThat(actual).isEqualTo(5)
    }
}
