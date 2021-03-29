package domain.lotto

import domain.winning.WinningCategory
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosTest {
    @ParameterizedTest(name = "총 로또 중 6개 모두 일치하는 로또의 개수는 {0}개여야 한다")
    @ValueSource(ints = [1, 2])
    fun `총 로또 중 6개 모두 일치하는 로또의 개수를 구한다`(expectedCount: Int) {
        // given
        val winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val lottos = Lottos((1..expectedCount).map { Lotto(winningNumbers) })
        val expected = mapOf(WinningCategory.SIX_CORRECT to expectedCount)

        // when
        val actual = lottos.matches(winningNumbers)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "총 로또 중 5개 일치하는 로또의 개수는 {0}개여야 한다")
    @ValueSource(ints = [1, 2])
    fun `총 로또 중 5개 일치하는 로또의 개수를 구한다`(expectedCount: Int) {
        // given
        val winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = lottoNumberOf(1, 2, 3, 4, 5, 45)
        val lottos = Lottos((1..expectedCount).map { Lotto(lottoNumbers) })
        val expected = mapOf(WinningCategory.FIVE_CORRECT to expectedCount)

        // when
        val actual = lottos.matches(winningNumbers)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
