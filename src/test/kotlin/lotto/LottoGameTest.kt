package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `금액을 입력받았을 때, 로또를 구매한다면, 최대 수량으로 구매를 한다`() {
        // given : 금액을 입력 받는다.
        val cash = 4500
        val lottoGame = LottoGame()

        // when : 로또를 구매한다.
        val lottoList = lottoGame.buyLotto(cash)

        // then : 입력 받은 금액의 최대 수량의 로또를 구매한다.
        assertThat(lottoList.size).isEqualTo(4)
    }
}
