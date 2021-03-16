package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoRankTest {

    @Test
    @DisplayName("로또 숫자가 맞은 개수를 입력하면 Rank를 리턴한다")
    fun findRank() {
        assertThat(LottoRank.findRank(0)).isEqualTo(LottoRank.OUT)
        assertThat(LottoRank.findRank(1)).isEqualTo(LottoRank.OUT)
        assertThat(LottoRank.findRank(2)).isEqualTo(LottoRank.OUT)
        assertThat(LottoRank.findRank(3)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.findRank(4)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.findRank(5)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.findRank(6)).isEqualTo(LottoRank.FIRST)
    }

    @Test
    @DisplayName("보너스 넘버를 맞췄는지 여부에 따라서 Rank가 달라진다.")
    internal fun findRankSecondAndBonus() {
        assertThat(LottoRank.findRank(5)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.findRank(5, true)).isEqualTo(LottoRank.BONUS)
    }

    @Test
    @DisplayName("rank 에 따라 안내하는 문자열이 달라진다.")
    internal fun infoString() {
        assertThat(LottoRank.findRank(5).infoString).isEqualTo("5개 일치 (1500000원)")
        assertThat(LottoRank.findRank(5, true).infoString).isEqualTo("5개 일치, 보너스 볼 일치(30000000원)")
    }
}
