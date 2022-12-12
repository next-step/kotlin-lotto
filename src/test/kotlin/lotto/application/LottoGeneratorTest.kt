package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    // given
    private val lotto = LottoGenerator.generateLottos(GENERATE_ONLY_ONE_LOTTO_NUMBERS).value[FIRST_INDEX]

    @Test
    fun `로또 번호 생성 - 개수(6개) 확인 테스트`() {
        // when, then
        assertThat(lotto.value.size).isEqualTo(Lotto.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @Test
    fun `로또 번호 생성 - 중복 번호 유무 확인 테스트`() {
        // when, then
        assertThat(lotto.value.distinct().size).isEqualTo(Lotto.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @Test
    fun `로또 번호 생성 - 범위(1~45) 확인 테스트`() {
        // when, then
        assertThat(lotto.value).allMatch { it in LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER }
    }

    @Test
    fun `로또 번호 생성 - 오름차순 정렬 확인 테스트`() {
        // when, then
        assertThat(lotto.value.map { it }).isSorted
    }

    companion object {
        private const val GENERATE_ONLY_ONE_LOTTO_NUMBERS = 1
        private const val FIRST_INDEX = 0
    }
}
