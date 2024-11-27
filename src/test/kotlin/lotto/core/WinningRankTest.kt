package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WinningRankTest {
    @Test
    fun `WinningCount로 WinningRank를 정상적으로 얻어지는 것을 확인한다`() {
        WinningRank.getWinningAmount(0) shouldBe WinningRank.RANK0
        WinningRank.getWinningAmount(1) shouldBe WinningRank.RANK0
        WinningRank.getWinningAmount(2) shouldBe WinningRank.RANK0
        WinningRank.getWinningAmount(3) shouldBe WinningRank.RANK4
        WinningRank.getWinningAmount(4) shouldBe WinningRank.RANK3
        WinningRank.getWinningAmount(5) shouldBe WinningRank.RANK2
        WinningRank.getWinningAmount(6) shouldBe WinningRank.RANK1
    }
}
