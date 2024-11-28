package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LottoResultTest {

    @Test
    fun calculateYield() {
        LottoResult(mapOf(WinningRank.FORTH to 1, WinningRank.NOTHING to 4)).calculateYield(5) shouldBe 10f
    }
}