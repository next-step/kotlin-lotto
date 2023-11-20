package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6 | 6 | 6",
            "2,3,4,5,6,7 | 8 | 5",
        ],
        delimiter = '|'
    )
    fun `전달받은 로또와 당첨 번호를 비교해 결과를 반환한다`(userLottoNumber: String, bonusNumber: Int, expected: Int) {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto.create(winningNumber, bonusNumber)
        val userLottoNumbers = LottoNumbers(userLottoNumber.split(",").map { LottoNumber(it.toInt()) })
        val userLottos = listOf(Lotto(userLottoNumbers))
        val result = winningLotto.match(userLottos)

        result.getLottoRankCount(expected) shouldBe 1
    }

    @Test
    fun `로또 번호 5개와 보너스 번호를 맞추면 2등이다`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto.create(winningNumber, 7)
        val userLottoNumbers = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        )
        val userLottos = listOf(Lotto(userLottoNumbers))
        val result = winningLotto.match(userLottos)

        result.getLottoRankingMatchCount(Revenue.SECOND) shouldBe 1
    }
}
