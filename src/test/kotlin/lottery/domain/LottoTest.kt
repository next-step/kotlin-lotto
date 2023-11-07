package lottery.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    @DisplayName("숫자 6개를 가지는 리스트로 로또 객체를 생성한다")
    fun lotto_create() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        lotto.lottoNumber shouldBe lottoNumbers
    }

    @Test
    @DisplayName("로또 객체는 숫자 6개를 가진다")
    fun lotto_count_six() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        lotto.lottoNumber.size shouldBe 6
    }

    @Test
    @DisplayName("로또 객체는 당첨 번호 정보를 가지는 로또 객체를 받아 일치하는 숫자 갯수를 반환한다")
    fun getMatchResult() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        lotto.getMatchResult(lotto.copy()) shouldBe 6
    }
}
