package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class TotalLottoReceiptTest {
    @Test
    fun `TotalLottoReceipt은 수동 로또 결과와 자동 로또 결과를 같이 보관한다`() {
        val lottoReceipt = LottoReceipt(
            PurchaseCount.from(1),
            PurchaseCount.from(1),
            Lottos.of(PurchaseCount.from(2), RangeLottoFactory())
        )

        val totalLottoReceipt = TotalLottoReceipt(
            manual = lottoReceipt,
            automatic = lottoReceipt
        )

        assertAll(
            { assertThat(totalLottoReceipt.manual).isEqualTo(lottoReceipt) },
            { assertThat(totalLottoReceipt.automatic).isEqualTo(lottoReceipt) }
        )
    }
}
