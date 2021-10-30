package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class MatchTest {
    @DisplayName("로또번호를 3개를 맞추면 상금이 5000원이다.")
    @Test
    fun `번호 3개 맞춘 상금`() {
        assertAll(
            { assertThat(Match.valueOf(3, true).prize).isEqualTo(5000) },
            { assertThat(Match.valueOf(3, false).prize).isEqualTo(5000) }
        )
    }

    @DisplayName("로또번호를 4개를 맞추면 상금이 50000원이다.")
    @Test
    fun `번호 4개 맞춘 상금`() {
        assertAll(
            { assertThat(Match.valueOf(4, true).prize).isEqualTo(50000) },
            { assertThat(Match.valueOf(4, false).prize).isEqualTo(50000) }
        )
    }

    @DisplayName("로또번호를 5개를 맞추면 상금이 1500000원이다.")
    @Test
    fun `번호 5개 맞춘 상금`() {
        assertThat(Match.valueOf(5, false).prize)
            .isEqualTo(1500000)
    }

    @DisplayName("로또번호를 5개와 보너스를 맞추면 상금이 30000000원이다.")
    @Test
    fun `번호 5개와 보너스 맞춘 상금`() {
        assertThat(Match.valueOf(5, true).prize)
            .isEqualTo(30000000)
    }

    @DisplayName("로또번호를 6개를 맞추면 상금이 2000000000원이다.")
    @Test
    fun `번호 6개 맞춘 상금`() {
        assertAll(
            { assertThat(Match.valueOf(6, true).prize).isEqualTo(2000000000) },
            { assertThat(Match.valueOf(6, false).prize).isEqualTo(2000000000) }
        )
    }
}
