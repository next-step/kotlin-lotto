package lotto.application

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 관리 테스트")
class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = ["1,1", "14,14"])
    @DisplayName("n개의 로또를 반환한다")
    fun `sut returns lottos`(lottoCount: Int, expected: Int) {
        // Arrange
        val sut = LottoService.from(lottoCount)

        // Act
        val lottos: List<Lotto> = sut.lottos

        // Assert
        assertThat(lottos).hasSize(expected)
    }
}
