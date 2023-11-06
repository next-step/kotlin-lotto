package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto).isNotNull
    }

    @Test
    fun `로또 번호를 가져올 수 있다`() {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.getLottoNumberList()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `로또 번호는 1부터 45까지의 숫자만 가능하다`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.")
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }
}
