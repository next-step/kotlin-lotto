package lotto.application

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 관리 테스트")
class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = ["1,1", "14,14"])
    @DisplayName("n개의 로또를 반환한다")
    fun `sut returns lottos`(lottoCount: Int, expected: Int) {
        // Arrange
        val sut = LottoService.generateAutoLotto(lottoCount)

        // Act
        val lottos: List<Lotto> = sut.lottos

        // Assert
        assertThat(lottos).hasSize(expected)
    }

    @Test
    @DisplayName("n개의 로또들의 당첨 결과를 수집할 수 있다")
    fun `sut returns match result`() {
        // Arrange
        val lottos = listOf(
            Lotto(listOf(3, 4, 5, 6, 7, 27)),
            Lotto(listOf(5, 7, 13, 27, 31, 45))
        )

        val winningNumber = WinningNumber.from(
            listOf("3", "5", "7", "13", "31", "45")
        )

        // Act
        val sut = LottoService(lottos)
        val result: Map<Rank, Int> = sut.matchWinningNumber(winningNumber)

        // Assert
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
    }
}
