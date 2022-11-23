package lotto.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName("로또 숫자는 랜덤하게 생성된다")
    @Test
    fun randomNumber() {
        val firstLotto = Lotto()
        val secondLotto = Lotto()

        val firstSum = firstLotto.list.sum()
        val secondSum = secondLotto.list.sum()

        assertThat(firstSum).isNotEqualTo(secondSum)
    }

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        val lotto = Lotto()

        assertThat(lotto.list.size).isEqualTo(6)
    }
}
