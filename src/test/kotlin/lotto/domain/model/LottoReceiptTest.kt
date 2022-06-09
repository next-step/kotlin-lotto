package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoReceiptTest {
    @Test
    fun `LottoReceipt은 구매한 로또에 대한 정보를 보관한다`() {
        val manualLottoCount = PurchaseCount.from(1)
        val automaticLottoCount = PurchaseCount.from(3)
        val lottos = Lottos.of(PurchaseCount.from(4), RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE))

        val lottoReceipt = LottoReceipt(manualLottoCount, automaticLottoCount, lottos)

        assertAll(
            { assertThat(lottoReceipt.manualLottoCount).isEqualTo(manualLottoCount) },
            { assertThat(lottoReceipt.automaticLottoCount).isEqualTo(automaticLottoCount) },
            { assertThat(lottoReceipt.lottos).isEqualTo(lottos) }
        )
    }
}
