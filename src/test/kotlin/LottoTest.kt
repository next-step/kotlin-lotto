import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class LottoTest {
    @Test
    fun `로또 숫자들로 로또를 생성할 수 있다`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber(it) }

        // when
        // then
        Lotto(lottoNumbers)
    }

    @Test
    fun `6개가 아닌 로또 숫자로 로또를 생성할 수 없다`() {
        // given
        val lottoNumbers = (1..7).map { LottoNumber(it) }

        // when
        // then
        assertThrows<RuntimeException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `중복된 숫자들이 포함된 로또 숫자들로 로또를 생성할 수 없다`() {
        // given
        val lottoNumbers = (1..3).map { LottoNumber(it) } + (1..3).map { LottoNumber(it) }

        // when
        // then
        assertThrows<RuntimeException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `로또 숫자들을 오름차순으로 조회할 수 있다`() {
        // given
        val reversedLottoNumbers = (1..6).reversed().map { LottoNumber(it) }

        // when
        val lotto = Lotto(reversedLottoNumbers)

        // then
        lotto.lottoNumbers.asSequence().windowed(2).forEach {
            assertThat(it[0].number <= it[1].number).isEqualTo(true)
        }
    }
}
