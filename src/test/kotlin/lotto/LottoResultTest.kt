package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    @DisplayName("구매한 로또번호와 우승 로또번호를 받아서 랭킹정보 전달")
    fun `sut calculate ranks by winningLotto and boughtLottos`() {
        // Arrange
        val winningLotto = WinningLottoNumbers(LottoNumbers(value = listOf(1, 2, 3, 4, 5, 6)), 40)
        val boughtLottos = listOf(
            LottoNumbers(value = listOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(value = listOf(2, 3, 4, 8, 9, 12)),
            LottoNumbers(value = listOf(4, 5, 10, 11, 20, 32))
        )

        val sut = LottoResult(winningLotto = winningLotto, boughtLottos = boughtLottos)

        // Act
        val ranks = sut.getRanks()

        // Assert
        assertThat(ranks.ranks.size).isEqualTo(3)
        assertThat(ranks.ranks.filter { it == Rank.FIRST }.size).isEqualTo(1)
        assertThat(ranks.ranks.filter { it == Rank.FIFTH }.size).isEqualTo(1)
        assertThat(ranks.ranks.filter { it == Rank.LOSING }.size).isEqualTo(1)
    }
}
