package lottery.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `숫자 6개를 가지는 리스트로 로또 객체를 생성한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.of(lottoNumbers)

        lotto.shouldBeInstanceOf<Lotto>()
    }

    @Test
    fun `로또 객체는 숫자 6개를 가진다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.of(lottoNumbers)

        lotto.lottoNumber.size shouldBe 6
    }

    @Test
    fun `로또 객체는 음수를 로또 번호로 가질 수 없다`() {
        val lottoNumbers = listOf(-1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Lotto.of(lottoNumbers)
        }
    }

    @Test
    fun `로또 객체는 45 이상의 수를 로또 번호로 가질 수 없다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            Lotto.of(lottoNumbers)
        }
    }
}
