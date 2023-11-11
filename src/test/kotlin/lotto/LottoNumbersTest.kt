package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

data class Lotto(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == 6) { INIT_ERROR_MESSAGE }
    }
    fun getSize(): Int {
        return numbers.size
    }

    companion object {
        private const val INIT_ERROR_MESSAGE: String = "로또 번호는 6개여야 합니다."
    }
}

class LottoNumbersTest {

    @Test
    fun `로또는 6개의 로또 번호를 가진다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        lotto.getSize() shouldBe 6
    }

    @Test
    fun `로또 번호는 6개여야만 한다`() {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(LottoNumber(1)))
        }
    }
}
