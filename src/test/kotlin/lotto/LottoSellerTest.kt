package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoNumberMatcher
import lotto.domain.LottoResultMapGenerator
import lotto.domain.LottoSeller
import lotto.domain.SetGenerator
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `로또 구매금액을 입력받는다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.purchasePrice).isEqualTo(5000)
    }

    @Test
    fun `로또 한장의 가격은 1000원이다`() {
        assertThat(LottoSeller.Companion.LOTTO_PRICE).isEqualTo(1000)
    }

    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.getLottoPurchaseCount()).isEqualTo(5)
    }

    @Test
    fun `갯수별 금액과 갯수를 곱해 수익금을 만든다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberMatcher = LottoNumberMatcher(winningNumbers)
        val lottoResultMapGenerator = LottoResultMapGenerator(lottoNumberMatcher)
        val setGenerator =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 4, 7)
                }
            }
        val lottoSeller = LottoSeller(4000)
        val lottoGenerator = LottoGenerator(setGenerator)
        val lottos = lottoGenerator.getLottos(lottoSeller.getLottoPurchaseCount())
        val resultMap = lottoResultMapGenerator.getResultMap(lottos)

        assertThat(lottoSeller.getProfitMap(resultMap)).contains(entry(4, 200000))
    }

    @Test
    fun `수익금을 구매금액으로 나누어 수익률을 구한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberMatcher = LottoNumberMatcher(winningNumbers)
        val lottoResultMapGenerator = LottoResultMapGenerator(lottoNumberMatcher)
        val setGenerator =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 4, 7)
                }
            }
        val lottoSeller = LottoSeller(4000)
        val lottoGenerator = LottoGenerator(setGenerator)
        val lottos = lottoGenerator.getLottos(lottoSeller.getLottoPurchaseCount())
        val resultMap = lottoResultMapGenerator.getResultMap(lottos)
        val profitMap = lottoSeller.getProfitMap(resultMap)
        assertThat(lottoSeller.getProfit(profitMap)).isEqualTo(200000)
    }

    @Test
    fun `수익률이 1보다 크면 이득 1이면 본전 1보다 작으면 손해로 판정한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        val lottoNumberMatcher = LottoNumberMatcher(winningNumbers)
        val lottoResultMapGenerator = LottoResultMapGenerator(lottoNumberMatcher)
        val setGenerator =
            object : SetGenerator {
                override fun getSet(): List<Int> {
                    return listOf(1, 2, 3, 4, 7)
                }
            }
        val lottoSeller = LottoSeller(4000)
        val lottoGenerator = LottoGenerator(setGenerator)
        val lottos = lottoGenerator.getLottos(lottoSeller.getLottoPurchaseCount())
        val resultMap = lottoResultMapGenerator.getResultMap(lottos)
        val profitMap = lottoSeller.getProfitMap(resultMap)
        val profit = lottoSeller.getProfit(profitMap)
        assertThat(lottoSeller.getProfitRate(profit)).isEqualTo(50.0)
    }
}
