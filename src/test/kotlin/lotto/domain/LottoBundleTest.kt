package lotto.domain

import lotto.enums.Rank
import lotto.service.AutoNumberCreateStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBundleTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100, 1000, 10000])
    fun `수량과 생성방식을 선택하면 로또묶음이 생성된다`(
        quantity: Int,
    ) {
        // Given & When
        val actual = LottoBundle.of(quantity, AutoNumberCreateStrategy())

        // Then
        assertThat(actual.bundle.size).isEqualTo(quantity)
    }

    @Test
    fun `수량만큼 로또를 생성한다`() {
        // Given
        val caseOfNumbers = listOf(
            Numbers(listOf(1, 2, 3, 4, 5, 6)),
            Numbers(listOf(1, 2, 3, 4, 5, 16)),
            Numbers(listOf(1, 2, 3, 4, 15, 16)),
            Numbers(listOf(1, 2, 3, 14, 15, 16)),
            Numbers(listOf(1, 2, 13, 14, 15, 16)),
            Numbers(listOf(1, 12, 13, 14, 15, 16))
        )
        val quantity = 2
        val strategyDouble = NumberCreateStrategyDouble(
            caseOfNumbers
        )

        // When
        val actual = LottoBundle.of(quantity, strategyDouble)

        // Then
        assertThat(actual.bundle.size).isEqualTo(quantity)
    }

    @Test
    fun `랭크별 수량을 집계한다`() {
        // Given
        val caseOfNumbers = listOf(
            Numbers(listOf(1, 2, 3, 4, 5, 6)),
            Numbers(listOf(1, 2, 3, 4, 5, 16)),
            Numbers(listOf(1, 2, 3, 4, 5, 17)),
            Numbers(listOf(1, 2, 3, 4, 15, 17)),
            Numbers(listOf(1, 2, 3, 14, 15, 16)),
            Numbers(listOf(1, 2, 13, 14, 15, 16)),
        )
        val strategyDouble = NumberCreateStrategyDouble(
            caseOfNumbers
        )
        val winningLotto = WinningLotto(
            Lotto.from(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(16)
        )
        val bundle = LottoBundle.of(caseOfNumbers.size, strategyDouble)

        // When
        val actual = bundle.findAllByMatchRanks(winningLotto)

        // Then
        val expected = listOf(
            Rank.FIRST_RANK,
            Rank.SECOND_BONUS_RANK,
            Rank.SECOND_RANK,
            Rank.THIRD_RANK,
            Rank.FOURTH_RANK,
            Rank.NONE_RANK
        )
        assertThat(actual).isEqualTo(expected)
    }
}
