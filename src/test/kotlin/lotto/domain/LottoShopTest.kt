package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoShopTest {

    @DisplayName("구입금액을 입력하면 로또 구입개수를 알 수 있다")
    @Test
    fun `purchase amount`() {
        assertThat(LottoShop(5000).makeLottos().size).isEqualTo(5)
    }

    @DisplayName("toString()을 하면, 로또 구입개수 정보를 반환한다")
    @Test
    fun `print toString()`() {
        assertThat(LottoShop(5000).toString()).isEqualTo("5개를 구매했습니다.")
    }
}
