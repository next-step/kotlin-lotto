package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test

internal class LottoServiceTest {
    @Test
    fun `구매 시 LottoRepository에 구입한 로또 저장`() {
        val totalPurchaseCount = 5

        LottoService.purchase(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 6)
            ),
            Lotto.PRICE * totalPurchaseCount
        )

        assertThat(LottoRepository.findAll()).hasSize(totalPurchaseCount)
            .map(Lotto::lottoNumbers)
            .contains(
                Tuple.tuple(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
            )
    }
}
