package lotto.rank

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `로또 번호 6개가 일치하면 1등이다`() {
        LottoRank.getRank(6) shouldBe LottoRank.FIRST
    }

    @Test
    fun `번호가 2개 이하로 일치하면 아무것도 해당하지 않는다`() {
        LottoRank.getRank(2) shouldBe LottoRank.NONE
    }
}

