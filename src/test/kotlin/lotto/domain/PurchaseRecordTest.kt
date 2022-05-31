package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PurchaseRecordTest {
    @Test
    fun `구매한 Lotto 들을 프로퍼티로 갖는다`() {
        val lottoList = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))
        Assertions.assertThat(PurchaseRecord(lottoList).lottoList)
            .isEqualTo(lottoList)
    }
}
