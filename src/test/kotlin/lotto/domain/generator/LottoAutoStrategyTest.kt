package lotto.domain.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 자동 생성 테스트")
class LottoAutoStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 14, 50])
    @DisplayName("구매한 로또 개수만큼 로또를 생성한다")
    fun `sut returns lottos made with lotto count`(lottoCount: Int) {
        // Arrange
        val sut = LottoAutoStrategy()

        // Act
        val lottos = sut.generate(lottoCount)

        // Assert
        assertThat(lottos).hasSize(lottoCount)
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45의 번호로 이루어져 있다")
    fun `sut returns lotto number size is 45`() {
        // Arrange
        val sut = LottoAutoStrategy()

        // Act
        val lottos = sut.generate(1)

        // Assert
        val lottoNumbers = lottos[0].getLottoNumbers()
        assertThat(lottoNumbers.first()).isGreaterThanOrEqualTo(1)
        assertThat(lottoNumbers.last()).isLessThanOrEqualTo(45)
    }
}
