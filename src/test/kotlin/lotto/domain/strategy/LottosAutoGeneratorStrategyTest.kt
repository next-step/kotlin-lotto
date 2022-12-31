package lotto.domain.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottosAutoGeneratorStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 5, 10])
    fun `로또를 구매한 개수만큼 로또가 만들어진다`(lottoCount: Int) {
        // given
        val autoLotto = LottoAutoGeneratorStrategy()

        // when
        val actual = autoLotto.generate(lottoCount).value.size

        // then
        assertThat(actual).isEqualTo(lottoCount)
    }

    @Test
    fun `로또 번호의 범위는 1부터 45까지다`() {
        // given
        val autoLotto = LottoAutoGeneratorStrategy()

        // when
        val actual = autoLotto.generate(1).value[0].value

        // then
        assertThat(actual.first()).isGreaterThanOrEqualTo(1)
        assertThat(actual.last()).isLessThanOrEqualTo(45)
    }
}
