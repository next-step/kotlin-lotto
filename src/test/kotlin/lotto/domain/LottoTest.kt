package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @Test
    fun `로또는 6개의 번호를 가진다`() {
        val lotto = Lotto()
        lotto.numbers.size shouldBe 6
    }

    @Test
    fun `로또 번호는 서로 다른 숫자로 이루어져있다`() {
        val lotto = Lotto()
        lotto.numbers.distinct().size shouldBe 6
    }

    @ParameterizedTest
    @CsvSource(value = ["1, true", "2, true", "3, true", "4, true", "5, true", "6, true", "7, false"])
    fun `로또에서 특정 로또 번호가 포함되어있는 지 확인할 수 있다`(number: Int, expected: Boolean) {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val lottoNumber = LottoNumber.from(number)
        lotto.hasLottoNumber(lottoNumber) shouldBe expected
    }

    @Test
    fun `로또와 다른 로또가 주어졌을 때, 몇 개가 일치하는 지 알 수 있다`() {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(setOf(1, 2, 3, 4, 5, 7))
        lotto.countMatchNumber(lotto2) shouldBe 5
    }
}
