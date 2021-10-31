package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoAutoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 5000, 10_000])
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`(givenValue: Int) {
        // given
        val budget = Budget.valueOf(givenValue)
        val lottoPrice = 1000
        val purchaseInformation = PurchaseInformation(budget, 0)
        val lottoAutoGenerator = LottoAutoGenerator(purchaseInformation)

        // when
        val actual = lottoAutoGenerator.generateLottos()

        // then
        assertThat(actual).hasSize(givenValue / lottoPrice)
    }
}
