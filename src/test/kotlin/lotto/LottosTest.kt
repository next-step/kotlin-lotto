package lotto

import lotto.fixture.createLottos
import lotto.fixture.createWinningLotto
import lotto.service.LottoShopService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottosTest {
    @Test
    fun `로또 결과 통계를 만들 수 있다`() {
        val budget = 5000
        val winningLotto = createWinningLotto(8, 3, 4, 7, 9, 10, 11)

        val lottos = createLottos(
            listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(3, 4, 5, 6, 7, 8),
                listOf(4, 5, 6, 7, 8, 9),
                listOf(4, 5, 6, 7, 9, 10),
                listOf(4, 6, 7, 8, 10, 11)
            )
        )

        val statistics = LottoShopService().winning(winningLotto, lottos, budget)

        assertAll({
            assertThat(statistics.totalPrizeMoney).isEqualTo(110000)
            assertThat(statistics.rateOfReturn).isEqualTo(22.0)
        })
    }
}
