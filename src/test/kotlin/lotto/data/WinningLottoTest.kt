package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `당첨 번호와 일치하는 번호 수 반환`() {
        // given : 당첨로또와 로또를 받는다.
        val lotto1 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        val lotto2 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7)))

        // 당첨번호 [1,2,3,4,5,7] + 보너스 번호 [6]
        val wLotto1 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7)))
        val winningLotto = WinningLotto(wLotto1, LottoNumber.from(6))

        // when : 검증 로직을 실행한다.
        val actual1 = winningLotto.countMatchingNumbers(lotto1)
        val actual2 = winningLotto.countMatchingNumbers(lotto2)

        // then : 일치하는 번호의 개수를 반환한다.
        assertThat(actual1).isEqualTo(5)
        assertThat(actual2).isEqualTo(6)
    }

    @Test
    fun `보너스 번호 일치 검증`() {
        // given : 당첨로또와 로또를 받는다.
        val lotto1 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        val lotto2 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7)))

        // 당첨번호 [1,2,3,4,5,7] + 보너스 번호 [6]
        val wLotto1 = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7)))
        val winningLotto = WinningLotto(wLotto1, LottoNumber.from(6))

        // when : 보너스 번호 일치 검증 로직을 호출한다.
        val actual1 = winningLotto.hasBonusNumber(lotto1)
        val actual2 = winningLotto.hasBonusNumber(lotto2)

        // then :
        assertThat(actual1).isTrue()
        assertThat(actual2).isFalse()
    }

    @Test
    fun `보너스 번호 중복 검증`() {
        // given : 당첨 번호로 구성된 로또와 이와 중복되는 보너스 번호를 받는다.
        val lotto = Lotto(LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        val bonusLottoNumber = LottoNumber.from(6)

        // when :
        val actual = runCatching { WinningLotto(lotto, bonusLottoNumber) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }
}
