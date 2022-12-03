package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    // given
    private val lottoNumbers = LottoGenerator.generate()

    @Test
    fun `로또 번호 생성 - 개수(6개) 확인 테스트`() {
        // when, then
        assertThat(lottoNumbers.value.size).isEqualTo(LottoNumbers.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @Test
    fun `로또 번호 생성 - 중복 번호 유무 확인 테스트`() {
        // when, then
        assertThat(lottoNumbers.value.distinct().size).isEqualTo(LottoNumbers.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @Test
    fun `로또 번호 생성 - 범위(1~45) 확인 테스트`() {
        // when, then
        assertThat(lottoNumbers.value).allMatch { it.value in LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER }
    }

    @Test
    fun `로또 번호 생성 - 오름차순 정렬 확인 테스트`() {
        // when, then
        assertThat(lottoNumbers.value.map { it.value }).isSorted
    }
}
