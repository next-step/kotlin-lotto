package lotto

import lotto.model.Lotto
import lotto.model.LottoStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore()
    }

    @ParameterizedTest(name = "로또 구입 금액은 1장에 1000원으로 계산된 만큼의 로또가 발급된다. {0} 원은 {1} 장으로 계산된다.")
    @CsvSource(
        value = [
            "14000|14",
            "0|0",
            "37500|37"
        ],
        delimiter = '|'
    )
    fun `로또 구입 금액은 1장에 1000원으로 계산된 만큼의 로또가 발급된다`(amount: Int, count: Int) {
        val resultCount = lottoStore.buy(amount)
        assertThat(resultCount.size).isEqualTo(count)
    }

    @ParameterizedTest(name = "구입 금액이 {0} 인 음수일 경우 IllegalArgumentException 예외가 발생한다.")
    @ValueSource(strings = ["-10000", "-5000"])
    fun `구입 금액이 0보다 적은 경우 IllegalArgumentException 예외가 발생한다`(amount: Int) {
        assertThrows<IllegalArgumentException> { lottoStore.buy(amount) }
    }

    @Test
    fun `수동으로 구매하는 로또 개수는 구입 금액을 초과한다면 IllegalArgumentException 예외가 발생한다`() {
        val amount = -1_000
        val manualLotto1 = Lotto(Fixtures.createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))

        assertThrows<IllegalArgumentException> { lottoStore.buy(amount, listOf(manualLotto1)) }
    }
}
