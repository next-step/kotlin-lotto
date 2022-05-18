package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class Lotto645BuilderTest {

    @Test
    fun `1~45 사이 숫자 중 6개를 랜덤하게 뽑아내어 로또를 만든다`() {

        val lotto = Lotto645Builder().createLotto()

        assertAll(
            { assertThat(lotto.numbers.filter { it !in 1..45 }).isEmpty() },
            { assertThat(lotto.numbers.size).isEqualTo(6) },
            { assertThat(lotto.numbers.distinct().size).isEqualTo(6) }
        )
    }
}
