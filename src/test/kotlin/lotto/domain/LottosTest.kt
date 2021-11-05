package lotto.domain

import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 관리 테스트")
class LottosTest {

    @Test
    @DisplayName("n개의 로또들의 당첨 결과를 수집할 수 있다")
    fun `sut returns match result`() {
        // Arrange
        val lottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumberFixture.create(1),
                        LottoNumberFixture.create(2),
                        LottoNumberFixture.create(3),
                        LottoNumberFixture.create(4),
                        LottoNumberFixture.create(5),
                        LottoNumberFixture.create(6),
                    )
                )
            ),
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumberFixture.create(1),
                        LottoNumberFixture.create(2),
                        LottoNumberFixture.create(3),
                        LottoNumberFixture.create(4),
                        LottoNumberFixture.create(5),
                        LottoNumberFixture.create(7),
                    )
                )
            )
        )

        val winningNumber = WinningNumber(
            listOf("1", "2", "3", "4", "5", "6")
        )
        val bonusNumber = 7

        // Act
        val sut = Lottos(lottos)
        val result: Map<Rank, Int> = sut.matchWinningNumber(LottoNumbers(winningNumber.value), bonusNumber)

        // Assert
        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
    }
}
