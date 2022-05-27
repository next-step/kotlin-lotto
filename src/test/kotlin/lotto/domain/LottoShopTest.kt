package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoShopTest {
    @ParameterizedTest
    @CsvSource("0,0", "1000,1", "10000,10")
    fun `금액을 입력하면 PurchaseRecord를 반환한다`(one: Int, numberOfLottos: Int) {
        Assertions.assertThat(LottoShop().purchase(one).lottoList.size).isEqualTo(numberOfLottos)
    }

    @ParameterizedTest
    @CsvSource("999,0", "1001,1", "1999,1", "2001,2")
    fun `천원단위로 떨어지지 않으면? 천원단위 내림하여 계산한다`(one: Int, numberOfLottos: Int) {
        Assertions.assertThat(LottoShop().purchase(one).lottoList.size).isEqualTo(numberOfLottos)
    }

    @Test
    fun `당첨번호(Lotto)를 반환한다`() {
        Assertions.assertThat(LottoShop().getWinningNumber()).isNotNull
    }
}
