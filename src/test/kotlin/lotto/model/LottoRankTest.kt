package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    @DisplayName("1등 찾기(일반)")
    fun `check match first rank when it has not bonus number`() {
        // given
        val sameNumberSix = 6

        // when
        val rank1 = LottoRank.findMatchRank(sameNumberSix)

        // then
        Assertions.assertThat(rank1).isEqualTo(LottoRank.FIRST)
    }

    @Test
    @DisplayName("2등 찾기(일반)")
    fun `check match third rank when it has not bonus number`() {
        // given
        val sameNumberFive = 5

        // when
        val rank2 = LottoRank.findMatchRank(sameNumberFive)

        // then
        Assertions.assertThat(rank2).isEqualTo(LottoRank.THIRD)
    }
    @Test
    @DisplayName("3등 찾기(일반)")
    fun `check match fourth rank when it has not bonus number`() {
        // given
        val sameNumberFour = 4

        // when
        val rank3 = LottoRank.findMatchRank(sameNumberFour)

        // then
        Assertions.assertThat(rank3).isEqualTo(LottoRank.FOURTH)
    }
    @Test
    @DisplayName("4등 찾기(일반)")
    fun `check match fifth rank when it has not bonus number`() {
        // given
        val sameNumberThree = 3

        // when
        val rank4 = LottoRank.findMatchRank(sameNumberThree)

        // then
        Assertions.assertThat(rank4).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    @DisplayName("모든 번호가 맞지 않은 경우의 등수 찾기(일반)")
    fun `check match zero rank when it has not bonus number`() {
        // given
        val sameNumberZero = 0

        // when
        val rank5 = LottoRank.findMatchRank(sameNumberZero)

        // then
        Assertions.assertThat(rank5).isEqualTo(LottoRank.MISS)
    }

    @Test
    @DisplayName("1등 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match first rank when it has bonus number`() {
        // given
        val sameNumberSix = 6

        // when
        val rank1 = LottoRank.findMatchRank(sameNumberSix, true)

        // then
        Assertions.assertThat(rank1).isEqualTo(LottoRank.FIRST)
    }

    @Test
    @DisplayName("2등 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match second rank when it has bonus number`() {
        // given
        val sameNumberFive = 5

        // when
        val rank2 = LottoRank.findMatchRank(sameNumberFive, true)

        // then
        Assertions.assertThat(rank2).isEqualTo(LottoRank.SECOND)
    }
    @Test
    @DisplayName("3등 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match four rank when it has bonus number`() {
        // given
        val sameNumberFour = 4

        // when
        val rank3 = LottoRank.findMatchRank(sameNumberFour, true)

        // then
        Assertions.assertThat(rank3).isEqualTo(LottoRank.FOURTH)
    }
    @Test
    @DisplayName("4등 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match five rank when it has bonus number`() {
        // given
        val sameNumberThree = 3

        // when
        val rank4 = LottoRank.findMatchRank(sameNumberThree, true)

        // then
        Assertions.assertThat(rank4).isEqualTo(LottoRank.FIFTH)
    }
    @Test
    @DisplayName("일치한 숫자가 없는 경우의 등수 찾기(보너스 숫자도 일치하는 경우)")
    fun `check match miss rank when it has bonus number`() {
        // given
        val sameNumberZero = 0

        // when
        val rank5 = LottoRank.findMatchRank(sameNumberZero, true)

        // then
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
