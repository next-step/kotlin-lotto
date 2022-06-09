package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoReceiptTest {
    @Test
    fun `LottoReceipt은 구매한 로또에 대한 정보를 보관한다`() {
        val purchaseCount = PurchaseCount.from(4)
        val lottos = Lottos.of(purchaseCount, RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE))

        val lottoReceipt = LottoReceipt(purchaseCount, lottos)

        assertAll(
            { assertThat(lottoReceipt.purchaseCount).isEqualTo(purchaseCount) },
            { assertThat(lottoReceipt.lottos).isEqualTo(lottos) }
        )
    }
}
