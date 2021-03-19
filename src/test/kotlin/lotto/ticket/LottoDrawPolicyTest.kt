package lotto.ticket

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class LottoDrawPolicyTest {

    // draw test
    @Test
    fun `(draw) 로또 뽑기는 6자리만 뽑는다`() {
        // given
        val policy: LottoDrawPolicy = ManualDrawPolicy("1,2,3,4,5,6,7")
        // when
        // then
        assertThat(policy.draw()).isEqualTo(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
    }

    @Test
    fun `(draw) 로또는 6자리 보다 적을 경우 예외발생`() {
        // given
        val policy: LottoDrawPolicy = ManualDrawPolicy("1,2,3,4,5")
        // when
        // then
        assertThrows<IllegalArgumentException> { policy.draw() }
    }

    @Test
    fun `(draw) 중복된 번호는 생략된다`() {
        // given
        val policy: LottoDrawPolicy = ManualDrawPolicy("1,2,3,4,5,5")
        // when
        // then
        assertThrows<IllegalArgumentException> { policy.draw() }
    }

    // Policy test

    @RepeatedTest(45)
    fun `(Policy) 수동 뽑기 전략은 들어온 문자를 로또 번호로 변환한다`(repetitionInfo: RepetitionInfo) {
        // given
        val index = repetitionInfo.currentRepetition
        val policy: LottoDrawPolicy = ManualDrawPolicy(index.toString())
        // when
        // then
        assertThat(policy.lottoNumbers).isEqualTo(setOf(LottoNumber(index)))
    }

    @ParameterizedTest
    @CsvSource("0", "46")
    fun `(Policy) 수동 뽑기 전략은 1~45범위 외의 숫자는 전략 적용 불가`(txNumber: String) {
        // given
        // when
        // then
        assertThrows<IllegalArgumentException> { ManualDrawPolicy(txNumber) }
    }
}
