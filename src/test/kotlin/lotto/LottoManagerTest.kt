package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoManagerTest {

    @Test
    fun `1000원으로 한개의 로또를 발급 받을 수 있다`() {
        val actual = LottoManager().buyLotto(1000, listOf())
        Assertions.assertThat(actual.size).isEqualTo(1)
    }

    @Test
    fun `한 개의 로또는 총 6개의 숫자로 이루어져 있다`() {
        val actual = LottoManager().buyLotto(1000, listOf())
        Assertions.assertThat(actual[0].numbers.size).isEqualTo(6)
    }

    @Test
    fun `발급 받은 6개의 숫자 중 중복 된 숫자는 있을 수 없다`() {
        val lotto = LottoManager().buyLotto(1000, listOf())
        val actual = lotto[0].numbers.toSet()
        Assertions.assertThat(actual.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [14000, 10000, 5000])
    fun `구입 금액 만큼 로또를 발급할 수 있다 발급의 기준은 1장 당 1000원`(money: Int) {
        val actual = LottoManager().buyLotto(money, listOf())
        Assertions.assertThat(actual.size).isEqualTo(money / 1000)
    }

    @ParameterizedTest
    @ValueSource(ints = [14000, 10000, 5000])
    fun `구매 금액으로 자동 로또와 수동 로또도 같이 발급 받을 수 있다`(money: Int) {
        val manualLottoNumbers = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val actual = LottoManager().buyLotto(money, manualLottoNumbers)
        Assertions.assertThat(actual.size).isEqualTo(money / 1000 + manualLottoNumbers.size)
    }
}
