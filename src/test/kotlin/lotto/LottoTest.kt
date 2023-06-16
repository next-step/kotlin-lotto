package lotto

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @Test
    fun `1 ~ 45 까지의 로또 번호에서 랜덤한 숫자 하나를 뽑을 수 있다`() {
        val actual = LottoNumber().getLottoNumber()
        assertThat(actual).isBetween(1, 45)
    }

    @Test
    fun `1000원으로 한개의 로또를 발급 받을 수 있다`() {
        val actual = Lotto().buyLotto(1000)
        assertThat(actual.size).isEqualTo(1)
    }

    @Test
    fun `한 개의 로또는 총 6개의 숫자로 이루어져 있다`() {
        val actual = Lotto().buyLotto(1000)
        assertThat(actual[0].size).isEqualTo(6)
    }

    @Test
    fun `발급 받은 6개의 숫자 중 중복 된 숫자는 있을 수 없다`() {
        val lotto = Lotto().buyLotto(1000)
        val actual = lotto[0].toSet()
        assertThat(actual.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [14000, 10000, 5000])
    fun `구입 금액 만큼 로또를 발급할 수 있다 발급의 기준은 1장 당 1000원`(money: Int) {
        val actual = Lotto().buyLotto(money)
        assertThat(actual.size).isEqualTo(money / 1000)
    }

    @ParameterizedTest
    @ValueSource(ints = [5000])
    fun `당첨 번호와 발급한 로또 번호를 비교하여 갯수별로(3개~6개) 당첨 개수를 산정할 수 있다`(money: Int) {
        val lottoBundle = listOf(listOf(1, 2, 3, 4, 5), listOf(2, 14, 26, 11, 4), listOf(5, 7, 17, 21, 33))
        val winningNumber = "1, 2, 3, 4, 5"
        val actual = LottoChecker().lottoCheck(winningNumber, lottoBundle)
        assertThat(actual[0]).isEqualTo(5)
        assertThat(actual[1]).isEqualTo(2)
        assertThat(actual[2]).isEqualTo(1)
    }

    @Test
    fun `당첨 개수를 전달 받아 당첨 금액을 산정할 수 있다`() {
        val collectCounts = listOf(3, 1, 3)
        val actual = LottoChecker().winningMoneyCheck(collectCounts)
        assertThat(actual).isEqualTo(10000)
    }

    @ParameterizedTest
    @CsvSource("14000, 5000")
    fun `산정 된 당첨 정보를 통해 구입한 금액과의 수일률을 구할 수 있다`(money: Int, winningMoney: Int) {
        val actual = Calculator().calculateRateOfReturn(money, winningMoney)
        actual shouldBe 0.35
    }
}
