package lotto.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import lotto.model.LottoPrize

class LottoResultAnalyzerTest : FunSpec({
    val analyzer = LottoResultAnalyzer()

    test("자연수가 아닌 로또 가격 입력 시 IllegalArgumentException 예외 발생 테스트") {
        val lottoNumbersCount = 1
        val lottoPrice = 0
        val lottoPrizes = listOf(LottoPrize.FIRST)

        shouldThrow<IllegalArgumentException> {
            analyzer.getRevenueRate(lottoNumbersCount, lottoPrice, lottoPrizes).toInt()
        }
    }
})
