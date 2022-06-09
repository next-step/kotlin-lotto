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

    @Test
    fun `더하기 연산자를 통해 두 LottoReceipt를 더할 수 있다`() {
        val manualLottoReceipt = LottoReceipt(
            manualLottoCount = PurchaseCount.from(3),
            automaticLottoCount = PurchaseCount.zero(),
            lottos = Lottos.of(PurchaseCount.from(3), RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE))
        )
        val automaticLottoReceipt = LottoReceipt(
            manualLottoCount = PurchaseCount.zero(),
            automaticLottoCount = PurchaseCount.from(4),
            lottos = Lottos.of(PurchaseCount.from(4), RangeLottoFactory(LottoNumber.LOTTO_NUMBER_RANGE))
        )

        val lottoReceipt = manualLottoReceipt + automaticLottoReceipt
        assertAll(
            { assertThat(lottoReceipt.manualLottoCount.value).isEqualTo(3) },
            { assertThat(lottoReceipt.automaticLottoCount.value).isEqualTo(4) },
            { assertThat(lottoReceipt.lottos.value.size).isEqualTo(7) },
            { assertThat(lottoReceipt.lottos.value).containsAll(manualLottoReceipt.lottos.value) },
            { assertThat(lottoReceipt.lottos.value).containsAll(automaticLottoReceipt.lottos.value) }
        )
    }
}
