package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PurchaseRecordTest {
    @Test
    fun `구매한 Lotto 들을 프로퍼티로 갖는다`() {
        Assertions.assertThat(PurchaseRecord(listOf(Lotto(listOf(1, 2)))).lottoList)
            .isEqualTo(listOf(Lotto(listOf(1, 2))))
    }
}
