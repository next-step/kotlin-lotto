import lotto.domain.Lotto
import lotto.domain.LottoMoney
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoResults
import lotto.domain.LottoResults.LottoResult
import lotto.service.LottoService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `getLottoNumbers는 구매 금액에 맞는 개수의 로또 번호를 생성한다`() {
        // Given
        val purchaseAmount = 5000
        val expectedQuantity = purchaseAmount / LottoMoney.LOTTO_COST

        // When
        val lottoNumbers = lottoService.getLottoNumbers(purchaseAmount)

        // Then
        assertThat(lottoNumbers).hasSize(expectedQuantity)
        lottoNumbers.forEach { lotto -> assertThat(lotto.lottoNumbers).hasSize(6) }
    }

    @Test
    fun `getLottoResult는 로또 리스트와 당첨 번호를 비교하여 결과를 반환한다`() {
        // Given
        val lottoList = listOf(
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                ),
            ),
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7),
                ),
            ),
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(11),
                    LottoNumber(12),
                    LottoNumber(13),
                    LottoNumber(14),
                    LottoNumber(15),
                ),
            ),
        )

        val winningNumbers = WinningLotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            ),
            bonusNumber = LottoNumber(7),
        )

        val expectedResults = LottoResults(
            listOf(
                LottoResult(LottoRank.NONE, 1),
                LottoResult(LottoRank.FIFTH, 0),
                LottoResult(LottoRank.FOURTH, 0),
                LottoResult(LottoRank.THIRD, 0),
                LottoResult(LottoRank.SECOND, 1),
                LottoResult(LottoRank.FIRST, 1),
            ),
        )

        // When
        val lottoResults = lottoService.getLottoResult(lottoList, winningNumbers)

        // Then
        assertThat(lottoResults.results).isEqualTo(expectedResults.results)
    }
}
