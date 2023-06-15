package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `1 ~ 45 까지의 로또 번호에서 랜덤한 숫자 하나를 뽑을 수 있다`() {
        val actual = LottoNumber().getLottoNumber()
        assertThat(actual).isBetween(1, 45)
    }

    @Test
    fun `1000원으로 한개의 로또를 발급 받을 수 있다`() {
        val actual = Lotto().buyLotto(1000)
        assertThat(actual.size).isEqualTo(1)
    }

    @Test
    fun `한 개의 로또는 총 6개의 숫자로 이루어져 있다`() {
        val actual = Lotto().buyLotto(1000)
        assertThat(actual[0].size).isEqualTo(6)
    }
}
