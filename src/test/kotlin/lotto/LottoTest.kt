package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {
    private val winnerNumbers = LottoNumbers.from(listOf(3, 6, 13, 15, 16, 22))

    @Test
    fun `번호 6개가 아닌 로또는 예외를 발생한다`() {
        assertThatThrownBy { Lotto(LottoNumbers.from(listOf(0))) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `번호 6개를 가진 로또를 생성할 수 있다`() {
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(lottoNumbers)
        lotto.lottoNumbers shouldBe lottoNumbers
    }

    @Test
    fun `번호 3개가 일치하면 5등이다`() {
        val lottoNumbers = LottoNumbers.from(listOf(3, 6, 13, 24, 25, 26))
        val lotto = Lotto(lottoNumbers)
        lotto.matchLotto(winnerNumbers, LottoNumber.from(1)) shouldBe LottoRank.FIFTH
    }

    @Test
    fun `번호 4개가 일치하면 4등이다`() {
        val lottoNumbers = LottoNumbers.from(listOf(3, 6, 13, 15, 25, 26))
        val lotto = Lotto(lottoNumbers)
        lotto.matchLotto(winnerNumbers, LottoNumber.from(1)) shouldBe LottoRank.FOURTH
    }

    @Test
    fun `번호 5개가 일치하면 3등이다`() {
        val lottoNumbers = LottoNumbers.from(listOf(3, 6, 13, 15, 16, 26))
        val lotto = Lotto(lottoNumbers)
        lotto.matchLotto(winnerNumbers, LottoNumber.from(1)) shouldBe LottoRank.THIRD
    }

    @Test
    fun `번호 5개가 일치하고 보너스 넘버가 일치하면 2등이다`() {
        val lottoNumbers = LottoNumbers.from(listOf(3, 6, 13, 15, 16, 26))
        val lotto = Lotto(lottoNumbers)
        lotto.matchLotto(winnerNumbers, LottoNumber.from(26)) shouldBe LottoRank.SECOND
    }

    @Test
    fun `번호 6개가 일치하면 1등이다`() {
        val lottoNumbers = LottoNumbers.from(listOf(3, 6, 13, 15, 16, 22))
        val lotto = Lotto(lottoNumbers)
        lotto.matchLotto(winnerNumbers, LottoNumber.from(26)) shouldBe LottoRank.FIRST
    }
}
