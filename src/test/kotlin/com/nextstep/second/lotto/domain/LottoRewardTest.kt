package com.nextstep.second.lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoRewardTest {
    @Test
    fun `5개 일치한 경우 FIFTH 의 보상을 반환한다`() {
        // given
        val sameNumberCount = 5
        val bonus = false

        // when
        val reward = LottoReward.valueOf(sameNumberCount, bonus)

        // then
        reward shouldBe LottoReward.FIFTH
    }

    @Test
    fun `5개 일치하고 보너스 번호가 일치한 경우 FIFTH_BONUS 의 보상을 반환한다`() {
        // given
        val sameNumberCount = 5
        val bonus = true

        // when
        val reward = LottoReward.valueOf(sameNumberCount, bonus)

        // then
        reward shouldBe LottoReward.FIFTH_BONUS
    }
}
