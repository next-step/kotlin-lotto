package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        val price = Lotto().price

        assertThat(price).isEqualTo(1000)
    }

    @Test
    fun `총 6개의 랜덤한 숫자로 된 로또를 생성할 수 있다`() {
        val lottoNumbers = Lotto().numbers

        assertThat(lottoNumbers).hasSize(6)
    }
}
