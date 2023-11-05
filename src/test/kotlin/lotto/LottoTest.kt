package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class Lotto(private val first: Int, private val second: Int, private val third: Int, private val fourth: Int, private val fifth: Int, private val sixth: Int) {

    init {
        val numbers = listOf(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth)

        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }

        require(numbers.distinct().size == numbers.size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getLottoNumberList(): List<Int> = listOf(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth)

    companion object {
        const val LOTTO_PRICE: Int = 1000
        private const val LOTTO_NUMBER_MIN: Int = 1
        private const val LOTTO_NUMBER_MAX: Int = 45
    }
}

class LottoTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto: Lotto = Lotto(1, 2, 3, 4, 5, 6)

        assertThat(lotto).isNotNull
    }

    @Test
    fun `로또 번호를 가져올 수 있다`() {
        val lotto: Lotto = Lotto(1, 2, 3, 4, 5, 6)

        assertThat(lotto.getLottoNumberList()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `로또 번호는 1부터 45까지의 숫자만 가능하다`() {
        assertThatThrownBy { Lotto(1, 2, 3, 4, 5, 46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.")
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        assertThatThrownBy { Lotto(1, 2, 3, 4, 5, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 중복될 수 없습니다.")
    }
}
