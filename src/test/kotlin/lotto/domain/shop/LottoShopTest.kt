package lotto.domain.shop

import lotto.domain.lotto.LottoTickets
import lotto.domain.money.PaidMoney
import lotto.fixture.manualLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

class LottoShopTest {
    private lateinit var lottoShop: LottoShop

    @BeforeEach
    fun beforeEachTest() {
        lottoShop = LottoShop()
    }

    @Test
    fun `수동 로또 수가 구매 가능한 로또 수보다 많으면 IllegalArgumentException 발생`() {
        // given
        val money = PaidMoney(1_000L)
        val manualLottos = manualLotto(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 16),
            listOf(1, 2, 3, 4, 5, 26),
        )

        // when

        // then
        assertThrows<IllegalArgumentException> {
            lottoShop.buyLotto(money, manualLottos)
        }
    }

    @Test
    fun `수동 로또 수가 구매 가능한 로또 수보다 적으면 구매 가능하다`() {
        // given
        val money = PaidMoney(4_000L)
        val manualLottos = manualLotto(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 16),
            listOf(1, 2, 3, 4, 5, 26),
        )

        // when
        val lottoTickets: LottoTickets = lottoShop.buyLotto(money, manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(4)
        assertThat(lottoTickets.toInts()).containsAll(manualLottos.lottos.toInts())
    }

    @Test
    fun `수동 로또만 구매도 가능하다`() {
        // given
        val money = PaidMoney(3_000L)
        val manualLottos = manualLotto(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 16),
            listOf(1, 2, 3, 4, 5, 26),
        )

        // when
        val lottoTickets = lottoShop.buyLotto(money, manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(3)
    }

    @Test
    fun `자동 로또만 구매도 가능하다`() {
        // given
        val money = PaidMoney(3_000L)

        // when
        val lottoTickets = lottoShop.buyLotto(money, manualLotto())

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(3)
    }

    @ParameterizedTest
    @CsvSource(value = ["14000|14", "1000|1", "2000|2"], delimiter = '|')
    fun `구입 금액만큼 로또를 구입할 수 있다`(money: Long, expected: Int) {
        // given
        val paidMoney = PaidMoney(money)

        // when
        val lottoTickets = lottoShop.buyLotto(paidMoney, manualLotto())

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(expected)
    }
}
