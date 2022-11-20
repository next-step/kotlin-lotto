package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test


internal class LottoTest {
    @Test
    fun `로또는 숫자 여섯개로 구성된다`() {
        val lotto = Lotto.generate()
        val lottoNumberCount = lotto.numbers.count()

        assertThat(lottoNumberCount).isEqualTo(6)
    }

    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto = Lotto.generate()
        val lottoNumberCount = lotto.numbers.count()

        assertThat(lottoNumberCount).isEqualTo(6)
    }

    @Test
    fun `로또번호는 오름차순 정렬되어 있다`() {
        val lottoNumbers = setOf(1,5,2,3,4,6)
        val lotto = Lotto(lottoNumbers)
        val sortedLottoNumbers = lottoNumbers.sorted().toSortedSet()

        assertThat(lotto.numbers).isEqualTo(sortedLottoNumbers)
    }

    @Test
    fun `로또번호가 6개가 아닌 경우 Exception을 발생시킨다`() {
        val lottoNumbers = setOf(1, 2, 3, 4, 5)

        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(lottoNumbers) }
    }

    @Test
    fun `로또번호가 1 미만의 값이 있을 경우 Exception을 발생시킨다`() {
        val lottoNumbers = setOf(0, 1, 2, 3, 4, 5)

        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(lottoNumbers) }
    }

    @Test
    fun `로또번호가 45 초과의 값이 있을 경우 Exception을 발생시킨다`() {
        val lottoNumbers = setOf(1, 2, 3, 4, 5, 46)

        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(lottoNumbers) }
    }
}