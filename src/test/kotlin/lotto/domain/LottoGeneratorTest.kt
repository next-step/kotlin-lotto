package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    // given
    private val lottoNumbers = LottoGenerator.generate()

    @DisplayName("로또 번호 생성 테스트 - 6개의 로또 번호 생성")
    @Test
    fun `로또 번호 생성 시 6개의 번호를 생성해야 한다`() {
        // when, then
        assertThat(lottoNumbers.value.size).isEqualTo(LottoNumbers.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @DisplayName("로또 번호 생성 테스트 - 중복 번호 생성 확인")
    @Test
    fun `로또 번호 생성 시 중복되는 번호가 없어야 한다`() {
        // when, then
        assertThat(lottoNumbers.value.distinct().size).isEqualTo(LottoNumbers.MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @DisplayName("로또 번호 생성 테스트 - 로또 번호 범위(1~45) 확인")
    @Test
    fun `로또 번호 생성 시 1부터 45까지의 숫자만 포함되어야 한다`() {
        // when, then
        assertThat(lottoNumbers.value).allMatch { it.value in LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER }
    }

    @DisplayName("로또 번호 생성 테스트 - 로또 번호 정렬 확인")
    @Test
    fun `로또 번호 생성 시 오름차순으로 정렬되어야 한다`() {
        // when, then
        assertThat(lottoNumbers.value.map { it.value }).isSorted
    }
}
