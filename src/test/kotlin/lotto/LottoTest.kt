package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `1 ~ 45 범위를 넘어가는 값을 받았다면, 로또를 생성했을 때, 오류를 던진다`() {
        // given : 범위를 벗어나는 값을 포함하여 번호를 구성한다.
        val inputData = listOf(1, 2, 3, 4, 5, 6, 50)

        // when : 로또를 생성한다.
        val actual = runCatching { Lotto(inputData) }.exceptionOrNull()

        // then : 오류를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `6개로 구성되지 않는 번호 구성을 받았다면, 로또를 생성했을 때, 오류를 던진다`() {
        // given : 6개로 구성되지 않은 번호 구성을 받는다.
        val inputData = listOf(1, 2, 3, 4, 5, 6, 7)

        // when : 로또를 생성한다.
        val actual = runCatching { Lotto(inputData) }.exceptionOrNull()

        // then : 오류를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `중복값을 포함한 6개의 번호 구성을 받았다면, 로또를 생성했을 때, 오류를 던진다`() {
        // given : 중복값을 포함한 6개의 번호 구성을 받는다.
        val inputData = listOf(1, 2, 3, 4, 5, 5)

        // when : 로또를 생성한다.
        val actual = runCatching { Lotto(inputData) }.exceptionOrNull()

        // then : 오류를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
