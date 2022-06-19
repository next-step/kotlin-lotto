package lotto.component

import lotto.domain.LottoMoney
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoFactoryTest {

    @Test
    fun `로또 번호 생성 규칙에 맞게 생성`() {
        val lottoList = LottoFactory.createLottoList(LottoMoney.from(1000), Only6LottoNumberGenerator)
        assertThat(lottoList).hasSize(1)
        assertThat(lottoList.flatMap { it.lottoNumbers.map { lottoNumber -> lottoNumber.number } })
            .containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `원하는 로또 개수만큼 생성`() {
        val lottoList = LottoFactory.createLottoList(LottoMoney.from(10000), RandomLottoNumberGenerator)

        assertThat(lottoList).hasSize(10)
        assertThat(lottoList.flatMap { it.lottoNumbers }.map { it.number })
            .allMatch { it in LottoNumber.START_LOTTO_NUMBER..LottoNumber.END_LOTTO_NUMBER }
    }

    private object Only6LottoNumberGenerator : LottoNumberGenerator {
        override fun generate(): List<LottoNumber> = (1..6).map { LottoNumber.from(it) }
    }
}
