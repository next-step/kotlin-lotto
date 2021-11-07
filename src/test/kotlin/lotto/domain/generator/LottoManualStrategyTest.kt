package lotto.domain.generator

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 수동 생성 테스트")
class LottoManualStrategyTest {

    @Test
    @DisplayName("n개의 수동 로또를 생성한다")
    fun `sut returns manual lottos`() {
        // Arrange
        val manualNumbers = listOf(
            "1, 2, 3, 4, 5, 6",
            "10, 11, 12, 13, 14, 15",
            "3, 9, 15, 27, 33, 45",
        )

        // Act
        val sut = LottoManualStrategy()
        val lottos = sut.generateManual(manualNumbers)

        // Assert
        assertThat(lottos).hasSize(3)
        assertThat(lottos.last().value).containsExactly(
            LottoNumber.valueOf(3),
            LottoNumber.valueOf(9),
            LottoNumber.valueOf(15),
            LottoNumber.valueOf(27),
            LottoNumber.valueOf(33),
            LottoNumber.valueOf(45),
        )
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45의 번호로 이루어져 있다")
    fun `sut returns lotto number size is 45`() {
        // Arrange
        val manualNumbers = listOf("5, 10, 15, 20, 25, 30")

        // Act
        val sut = LottoManualStrategy()
        val lottos = sut.generateManual(manualNumbers)

        // Assert
        val lottoNumbers = lottos.first().getLottoNumbers()
        assertThat(lottoNumbers.first()).isGreaterThanOrEqualTo(1)
        assertThat(lottoNumbers.last()).isLessThanOrEqualTo(45)
    }
}
