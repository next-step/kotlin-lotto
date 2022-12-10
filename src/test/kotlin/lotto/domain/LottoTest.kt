package lotto.domain

import lotto.domain.model.Lotto
import org.assertj.core.api.AssertionsForClassTypes
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTest {

    @DisplayName("로또는 숫자 6개로 구성되어야 합니다")
    @Test
    fun numberSize() {
        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
            }
            .withMessageMatching("로또는 숫자 6개로 구성되어야 합니다")

        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Lotto(listOf(1, 2, 3, 4, 5))
            }
            .withMessageMatching("로또는 숫자 6개로 구성되어야 합니다")
    }

    @DisplayName("로또는 1부터 45 사이의 숫자로 구성되어야 합니다")
    @Test
    fun lottoNumberRange() {
        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Lotto(listOf(1, 2, 3, 49, 5, 6))
            }
            .withMessageMatching("로또는 1부터 45 사이의 숫자로 구성되어야 합니다")
    }

    @DisplayName("로또는 중복되지 않는 숫자로 구성되어야 합니다")
    @Test
    fun duplicate() {
        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                Lotto(listOf(1, 2, 3, 3, 5, 6))
            }
            .withMessageMatching("로또는 중복되지 않는 숫자로 구성되어야 합니다")
    }

    @DisplayName("로또 숫자들은 오름차순으로 정렬된다")
    @Test
    fun orderASC() {
        val lotto = Lotto()
        val first = lotto.numbers[0]
        val second = lotto.numbers[1]

        assertThat(first).isLessThan(second)
    }
}
