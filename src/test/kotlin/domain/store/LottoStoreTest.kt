package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.lotto.lottoNumberOf
import domain.money.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoStoreTest {
    @Test
    fun `로또판매기는 로또 가격으로 생성된다`() {
        assertDoesNotThrow { LottoStore(price = Money(1000)) }
    }

    @Test
    fun `로또판매기의 로또 가격은 0원일 수 없다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy { LottoStore(Money.ZERO) }
    }

    @Test
    fun `로또판매기에 돈을 주고 로또들을 살 수 있다`() {
        val store = LottoStore(Money(1000))
        assertDoesNotThrow {
            val lottos: List<Lotto> = store.buyLottos(Money(1000))
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 999, 0",
        "1000, 1001, 1",
        "1000, 10000, 10",
        "500, 999, 1",
        "500, 1001, 2",
        "500, 10000, 20"
    )
    fun `로또판매기에 준 돈으로 살 수 있는 최대한의 로또를 살 수 있다`(lottoPrice: Long, moneyToBuy: Long, lottoCount: Int) {
        val store = LottoStore(Money(lottoPrice))
        Assertions.assertThat(store.buyLottos(Money(moneyToBuy))).hasSize(lottoCount)
    }

    @Test
    fun `로또판매기에 돈과 함께 수동 선택한 숫자열을 주고 로또를 사면, 선택한 숫자열이 담긴 로또를 살 수 있다`() {
        // given
        val store = LottoStore(Money(1000))
        val expected: List<LottoNumbers> = listOf(lottoNumberOf(1, 2, 3, 4, 5, 6))

        // when
        val boughtLottos = store.buyLottos(Money(1000), listOf(lottoNumberOf(1, 2, 3, 4, 5, 6)))
        val actual = boughtLottos.map { it.numbers }

        // then
        assertThat(actual).containsAnyElementsOf(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "5000, 5",
        "4500, 4"
    )
    fun `로또판매기에 수동 선택한 숫자열을 주고 로또를 사더라도, 주어진 금액으로 살 수 있는 최대한의 로또만을 살 수 있다`(
        money: Long,
        boughtCount: Int
    ) {
        // given
        val store = LottoStore(price = Money(1000))

        // when
        val actual = store.buyLottos(Money(money), listOf(lottoNumberOf(1, 2, 3, 4, 5, 6)))

        // then
        assertThat(actual).hasSize(boughtCount)
    }

    @Test
    fun `금액에 비례한 구매 수량보다 수동 선택 개수가 많지 않아야 한다`() {
        val store = LottoStore(Money(1000))
        val manualPicks = listOf(
            lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottoNumberOf(1, 2, 3, 4, 5, 6)
        )

        assertThatIllegalArgumentException().isThrownBy { store.buyLottos(Money(1000), manualPicks) }
    }

    @Test
    fun `로또판매기에서 로또를 살 때, 수동 입력한 순서대로 구매한 로또의 맨앞에서부터 바뀐다`() {
        // given
        val randomNumbers = lottoNumberOf(40, 41, 42, 43, 44, 45)
        val randomLottoNumbersGenerator = object : RandomLottoNumberGenerator {
            override fun generate() = randomNumbers
        }
        val store = LottoStore(Money(1000), randomLottoNumbersGenerator)
        val manualPicks = listOf(
            lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottoNumberOf(7, 8, 9, 10, 11, 12)
        )
        val expectedList: List<LottoNumbers> = manualPicks + randomNumbers

        // when
        val boughtLottos = store.buyLottos(Money(3000), manualPicks)
        val actualList = boughtLottos.map { it.numbers }

        // then
        assertThat(actualList).containsExactlyElementsOf(expectedList)
    }
}
