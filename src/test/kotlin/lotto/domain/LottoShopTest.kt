package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {

    @Test
    fun `purchase amount`() {
        assertThat(LottoShop(5000).makeLottos().size).isEqualTo(5)
    }

    @Test
    fun `print toString`() {
        assertThat(LottoShop(5000).toString()).isEqualTo("5개를 구매했습니다.")
    }
}
