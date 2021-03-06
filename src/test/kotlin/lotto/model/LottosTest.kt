package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottosTest {
    @Test
    fun `구매할 수 있는 로또 갯수를 인자로 주면, 해당 갯수만큼 Lotto를 가진 Lottos 객체가 생성된다`() {
        // given
        val lottoCount = 5

        // when
        val myLottos = Lottos(lottoCount)

        // then
        assertThat(myLottos.lottos.size).isEqualTo(5)
    }
}