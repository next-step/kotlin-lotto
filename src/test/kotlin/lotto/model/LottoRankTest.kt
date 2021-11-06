package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    @DisplayName("일치한 숫자에 맞는 등수 찾기(일반)")
    fun `check match rank when it has not bonus number`() {
        // given
        val numberOne = 6
        val numberTwo = 5
        val numberThree = 4
        val numberFour = 3
        val numberFive = 0

        // when
        val rank1 = LottoRank.findMatchRank(numberOne)
        val rank2 = LottoRank.findMatchRank(numberTwo)
        val rank3 = LottoRank.findMatchRank(numberThree)
        val rank4 = LottoRank.findMatchRank(numberFour)
        val rank5 = LottoRank.findMatchRank(numberFive)

        // then
        Assertions.assertThat(rank1).isEqualTo(LottoRank.FIRST)
        Assertions.assertThat(rank2).isEqualTo(LottoRank.THIRD)
        Assertions.assertThat(rank3).isEqualTo(LottoRank.FOURTH)
        Assertions.assertThat(rank4).isEqualTo(LottoRank.FIFTH)
        Assertions.assertThat(rank5).isEqualTo(LottoRank.MISS)
    }

    @Test
    @DisplayName("일치한 숫자에 맞는 등수 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match rank when it has bonus number`() {
        // given
        val numberOne = 6
        val numberTwo = 5
        val numberThree = 4
        val numberFour = 3
        val numberFive = 0

        // when
        val rank1 = LottoRank.findMatchRank(numberOne, true)
        val rank2 = LottoRank.findMatchRank(numberTwo, true)
        val rank3 = LottoRank.findMatchRank(numberThree, true)
        val rank4 = LottoRank.findMatchRank(numberFour, true)
        val rank5 = LottoRank.findMatchRank(numberFive, true)

        // then
        Assertions.assertThat(rank1).isEqualTo(LottoRank.FIRST)
        Assertions.assertThat(rank2).isEqualTo(LottoRank.SECOND)
        Assertions.assertThat(rank3).isEqualTo(LottoRank.FOURTH)
        Assertions.assertThat(rank4).isEqualTo(LottoRank.FIFTH)
        Assertions.assertThat(rank5).isEqualTo(LottoRank.MISS)
    }

    @Test
    @DisplayName("보너스 번호가 없는 상황에서의 2등 확인")
    fun `check second rank when it has not bonus number`() {
        // given
        val hasBonusNumber = false
        val sameNumberCount = 5

        // when
        val secondRank = LottoRank.isBonusRank(hasBonusNumber)
        val findSecondRank = LottoRank.findMatchRank(sameNumberCount, false)

        // then
        Assertions.assertThat(secondRank).isEqualTo(LottoRank.THIRD)
        Assertions.assertThat(secondRank).isEqualTo(findSecondRank)
    }

    @Test
    @DisplayName("보너스 번호가 있는 상황에서의 2등 확인")
    fun `check second rank when it has bonus number`() {
        // given
        val hasBonusNumber = true
        val sameNumberCount = 5

        // when
        val secondRank = LottoRank.isBonusRank(hasBonusNumber)
        val findSecondRank = LottoRank.findMatchRank(sameNumberCount, true)

        // then
        Assertions.assertThat(secondRank).isEqualTo(findSecondRank)
    }
}
