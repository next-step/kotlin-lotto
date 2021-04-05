package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.lotto.Lottos
import domain.lotto.PickType
import domain.lotto.lottoNumberOf
import domain.money.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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
            val lottos: Lottos = store.buyLottos(Money(1000))
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
        assertThat(store.buyLottos(Money(moneyToBuy)).toList()).hasSize(lottoCount)
    }

    @Test
    fun `로또판매기에 돈과 함께 수동 선택한 숫자열을 주고 로또를 사면, 선택한 숫자열이 담긴 로또를 살 수 있다`() {
        // given
        val store = LottoStore(Money(1000))
        val expected: List<LottoNumbers> = listOf(lottoNumberOf(1, 2, 3, 4, 5, 6))

        // when
        val boughtLottos = store.buyLottos(
            money = Money(1000),
            manualPicks = ManualPicks(listOf(lottoNumberOf(1, 2, 3, 4, 5, 6)))
        )
        val actual = boughtLottos.toList().map { it.numbers }

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
        val actual = store.buyLottos(
            money = Money(money),
            manualPicks = ManualPicks(listOf(lottoNumberOf(1, 2, 3, 4, 5, 6)))
        ).toList()

        // then
        assertThat(actual).hasSize(boughtCount)
    }

    @Test
    fun `금액에 비례한 구매 수량보다 수동 선택 개수가 많지 않아야 한다`() {
        val store = LottoStore(Money(1000))
        val manualPicks = ManualPicks(
            listOf(
                lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottoNumberOf(1, 2, 3, 4, 5, 6)
            )
        )

        assertThatIllegalArgumentException().isThrownBy { store.buyLottos(Money(1000), manualPicks) }
    }

    @Test
    fun `수동선택 없이 생성한 로또는 전부 자동타입이다`() {
        // given
        val lottoPrice = Money(1000)
        val store = LottoStore(lottoPrice)
        // when
        val actual: List<Lotto> = store.buyLottos(lottoPrice * 10).toList()
        // then
        assertThat(actual).hasSize(10).allMatch { it.pickType == PickType.AUTO }
    }

    @Test
    fun `로또판매기에서 로또를 살 때, 수동 입력한 순서대로 구매한 로또의 맨앞에서부터 바뀐다`() {
        // given
        val randomNumbers = lottoNumberOf(40, 41, 42, 43, 44, 45)
        val randomLottoNumbersGenerator = object : RandomLottoNumberGenerator {
            override fun generate() = randomNumbers
        }
        val store = LottoStore(Money(1000), randomLottoNumbersGenerator)
        val manualPickNumbersList = listOf(
            lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottoNumberOf(7, 8, 9, 10, 11, 12)
        )
        val expectedNumbersList: List<LottoNumbers> = manualPickNumbersList + randomNumbers

        // when
        val actualList = store.buyLottos(Money(3000), ManualPicks(manualPickNumbersList)).toList()

        // then
        assertAll(
            { assertThat(actualList.map { it.numbers }).containsExactlyElementsOf(expectedNumbersList) },
            { assertThat(actualList.take(2)).allMatch { it.pickType == PickType.MANUAL } }
        )
    }
}
