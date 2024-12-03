package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoRank
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {
    @Test
    fun `일치하는 갯수가 6개이면 1등이다`() {
        LottoRank.from(6, false) shouldBe LottoRank.FIRST
    }

    @Test
    fun `일치하는 갯수가 5개이고 보너스 번호가 일치하면 2등이다`() {
        LottoRank.from(5, true) shouldBe LottoRank.SECOND
    }

    @Test
    fun `일치하는 갯수가 5개이고 보너스 번호가 불일치하면 3등이다`() {
        LottoRank.from(5, false) shouldBe LottoRank.THIRD
    }

    @ValueSource(booleans = [true, false])
    @ParameterizedTest
    fun `일치하는 갯수가 4개이면 4등이다`(matchBonus: Boolean) {
        LottoRank.from(4, matchBonus) shouldBe LottoRank.FOURTH
    }

    @ValueSource(booleans = [true, false])
    @ParameterizedTest
    fun `일치하는 갯수가 3개이면 5등이다`(matchBonus: Boolean) {
        LottoRank.from(3, matchBonus) shouldBe LottoRank.FIFTH
    }

    @ValueSource(ints = [0, 1, 2])
    @ParameterizedTest
    fun `일치하는 갯수가 2개 이하면 순위 밖이다`(matchCount: Int) {
        LottoRank.from(matchCount, false) shouldBe LottoRank.UNRANKED
    }
}
