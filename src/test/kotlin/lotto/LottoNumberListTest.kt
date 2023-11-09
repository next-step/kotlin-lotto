package lotto

import lotto.domain.LottoNumberList
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberListTest {

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        val lottoNumberList: LottoNumberList = LottoNumberList(listOf(6, 5, 4, 3, 2, 1))

        assertThat(lottoNumberList.numberList).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `로또 번호는 1부터 45까지의 숫자만 가능하다`() {
        Assertions.assertThatThrownBy { LottoNumberList(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.")
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        Assertions.assertThatThrownBy { LottoNumberList(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }
}