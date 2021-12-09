package lotto.entity

import lotto.domain.entity.common.LottoNumber
import lotto.domain.entity.user.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @Test
    fun `원하는 로또 번호를 생성 할 수 있다 `() {

        val customLottoNumber = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(43),
            LottoNumber(44),
            LottoNumber(45),
            LottoNumber(22)
        ).sortedBy { it.number }

        val lotto = Lotto(customLottoNumber)

        checkSameLottoNumber(lotto.getLottoNumber(), customLottoNumber, 6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3,5", "1,19,31,34,36,44,45"])
    fun `생성된 로또 번호가 로또 번호 개수인(6개)가 아닐시 IllegalArgumentException 예외가 발생한다`(lottoNumber: String) {
        assertThrows<IllegalArgumentException> {
            Lotto(
                lottoNumber
                    .split(",")
                    .map { LottoNumber(it.trim().toInt()) }
                    .sortedBy { it.number }
                    .toList()
            )
        }
    }

    private fun checkSameLottoNumber(createLotto: List<LottoNumber>, customLotto: List<LottoNumber>, size: Int) {

        assertThat(createLotto.size).isEqualTo(size)
        assertThat(customLotto.size).isEqualTo(size)

        for (i in 0 until size) {
            assertThat(createLotto[i].number).isEqualTo(customLotto[i].number)
        }
    }
}
