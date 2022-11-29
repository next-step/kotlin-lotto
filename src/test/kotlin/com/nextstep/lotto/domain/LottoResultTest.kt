package com.nextstep.lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : FunSpec({

    context("Result") {
        test("결과계산하면 수익률이 계산된다.") {
            val lottoResult = LottoResult(mapOf(Rank.FIRST to 1, Rank.THIRD to 2))
            lottoResult.calculateRatio(3000L) shouldBe 667666.0
        }
    }
})
