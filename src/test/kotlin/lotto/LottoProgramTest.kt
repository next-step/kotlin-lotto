package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoProgramTest {
    @DisplayName("구입한 금액 만큼의 로또 장수를 반환한다.")
    @Test
    fun `when input amountOfMoney then return amountOfLotto`() {
        assertThat(LottoProgram.getAmountOfLotto(3000)).isEqualTo(3)
    }

    @DisplayName("로또의 수익률을 계산한다.")
    @Test
    fun calculateRateOfReturn() {
        val ranks = listOf(Rank.FIFTH)
        val amountOfMoney = 14000
        assertThat(LottoProgram.calculateRateOfReturn(ranks, amountOfMoney)).isEqualTo(0.36)
    }

    @DisplayName("수동 로또의 갯수가 구입한 로또 수보다 작으면 true, 아니면 false를 반환한다.")
    @Test
    fun validateAmountOfManualLotto() {
        val func = LottoProgram.validateAmountOfManualLotto()
        assertAll(
            { assertThat(func(1, 5)).isTrue() },
            { assertThat(func(6, 5)).isFalse() }
        )
    }

    @DisplayName("보너스 볼이 1과 45 사이에 있으면 true, 아니면 false를 반환한다.")
    @Test
    fun validateBonusBallRange() {
        val func = LottoProgram.validateBonusBallRange()
        assertAll(
            { assertThat(func(20)).isTrue() },
            { assertThat(func(50)).isFalse() }
        )
    }

    @DisplayName("입력한 금액이 1000원 단위이고, 0이 아니면 true, 그렇지않으면 false를 반환한다.")
    @Test
    fun validateMoneyUnit() {
        val func = LottoProgram.validateMoneyUnit()
        assertAll(
            { assertThat(func(2000)).isTrue() },
            { assertThat(func(0)).isFalse() },
            { assertThat(func(134)).isFalse() }
        )
    }

    @DisplayName("숫자 목록에 중복이 없으면 true, 있으면 false를 반환한다.")
    @Test
    fun isNotDuplicated() {
        val func = LottoProgram.isNotDuplicated()
        assertAll(
            { assertThat(func(listOf(1, 2, 3, 4, 5, 6))).isTrue() },
            { assertThat(func(listOf(1, 1, 2, 3, 4, 5))).isFalse() }
        )
    }
}
