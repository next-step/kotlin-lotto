package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `번호 조합을 입력 받았을 때, 로또 번호 조합을 생성할 수 있다`() {
        // given :

        // when : 번호 조합을 입력 받았을 때
        val selectNumberList = listOf(1, 2, 3, 4, 5, 6)

        // then : 로또 번호 조합을 생성할 수 있다.
        val lottoNumbers = LottoNumber.createLottoNumbers(selectNumberList)
        val expect = LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lottoNumbers).isEqualTo(expect)
    }

    @Test
    fun `1 ~ 45 범위를 넘어가는 값을 받았다면, 로또를 생성했을 때, 예외를 던진다`() {
        // given : 범위를 벗어나는 값을 포함하여 번호를 구성한다.
        val selectNumberList = listOf(1, 2, 3, 4, 5, 450)

        // when : 로또번호를 구성한다.
        val actual = runCatching { LottoNumber.createLottoNumbers(selectNumberList) }.exceptionOrNull()

        // then : 예외를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
