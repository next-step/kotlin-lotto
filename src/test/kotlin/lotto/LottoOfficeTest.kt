package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoOfficeTest {
    private val sut = LottoOffice

    @Test
    fun `sut bought tickets correctly coun정t`() {
        // Arrange
        val buyPrice = BuyPrice(14_000)

        // Act
        val boughtTickets = sut.buyTickets(buyPrice)

        // Assert
        assertThat(boughtTickets).isEqualTo(14)
    }

    @Test
    fun `sut get ranks`() {
        // Arrange
        val winnerNumbers = listOf(1, 2, 3, 4, 5, 6)
        val boughtLottos = listOf(
            listOf(1, 2, 3, 4, 5, 6), // 6 matched
            listOf(1, 2, 3, 4, 5, 7), // 5 matched
            listOf(1, 2, 3, 4, 7, 8), // 4 matched
            listOf(1, 2, 3, 7, 8, 9), // 3 matched
            listOf(1, 2, 3, 7, 8, 9), // 3 matched
            listOf(10, 11, 12, 13, 14, 15), // not matched
        )

        // Act
        val ranks = sut.getRanks(winnerNumbers, boughtLottos)

        // Assert
        assertAll(
            { assertThat(ranks.filter { it.matchCount == 6 }.size).isEqualTo(1) },
            { assertThat(ranks.filter { it.matchCount == 5 }.size).isEqualTo(1) },
            { assertThat(ranks.filter { it.matchCount == 4 }.size).isEqualTo(1) },
            { assertThat(ranks.filter { it.matchCount == 3 }.size).isEqualTo(2) },
            { assertThat(ranks.filter { it.name == Rank.LOSING.name }.size).isEqualTo(1) }
        )
    }
}
