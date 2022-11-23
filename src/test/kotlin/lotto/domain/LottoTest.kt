package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName("로또 숫자는 랜덤하게 생성된다")
    @Test
    fun randomNumber() {
        val lotto = Lotto()
        val lotto2 = Lotto()

        val sum = lotto.list.first() + lotto.list.last()
        val sum2 = lotto2.list.first() + lotto2.list.last()

        assertThat(sum).isNotEqualTo(sum2)
    }

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        TODO("Not yet implemented")
    }
}
