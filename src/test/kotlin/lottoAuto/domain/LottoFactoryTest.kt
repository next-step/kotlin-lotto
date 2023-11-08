package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoFactoryTest {
    @Test
    fun `주어진 수만큼 Lotto 객체를 생성한다`() {
        // given
        val numOfLotto = 10

        // when
        val lottos = LottoFactory.create(10)

        // then
        assertEquals(numOfLotto, lottos.size)
    }
}
