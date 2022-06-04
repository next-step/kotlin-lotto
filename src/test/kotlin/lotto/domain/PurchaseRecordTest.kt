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

    @Test
    fun `수동구매한 로또들과 payment를 파라미터로 받아 PurchaseRecord를 반환한다`() {
        val payment = Payment(10000)
        val manualLottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            Lotto(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber(it) }),
        )

        Assertions.assertThat(PurchaseRecord.purchase(manualLottos, payment.getAvailableNumberOfLotto()).lottoList.size)
            .isEqualTo(10)
    }
}
