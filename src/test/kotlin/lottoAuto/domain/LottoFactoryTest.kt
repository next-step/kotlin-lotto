package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoFactoryTest {
    @ParameterizedTest
    @CsvSource(
        "999, 0",
        "1000, 1",
        "14999, 14"
    )
    fun `구매 가능한 매수만큼 Lotto를 생성한다`(purchaseAmount: Int, expected: Int) { // given
        // when
        val lottos = LottoFactory.create(purchaseAmount)

        // then
        assertEquals(expected, lottos.size)
    }
}
