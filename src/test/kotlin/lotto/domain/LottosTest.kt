package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 관리 테스트")
class LottosTest {

    private val lottoNumberOne = LottoNumber(1)
    private val lottoNumberTwo = LottoNumber(2)
    private val lottoNumberThree = LottoNumber(3)
    private val lottoNumberFour = LottoNumber(4)
    private val lottoNumberFive = LottoNumber(5)
    private val lottoNumberSix = LottoNumber(6)
    private val lottoNumberSeven = LottoNumber(7)

    @Test
    @DisplayName("n개의 로또들의 당첨 결과를 수집할 수 있다")
    fun `sut returns match result`() {
        // Arrange
        val lottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        lottoNumberOne, lottoNumberTwo, lottoNumberThree, lottoNumberFour, lottoNumberFive, lottoNumberSix,
                    )
                )
            ),
            Lotto(
                LottoNumbers(
                    listOf(
                        lottoNumberOne, lottoNumberTwo, lottoNumberThree, lottoNumberFour, lottoNumberFive, lottoNumberSeven,
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
