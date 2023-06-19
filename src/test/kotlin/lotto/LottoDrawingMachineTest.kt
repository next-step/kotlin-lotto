package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoDrawingMachineTest : StringSpec({
    val sut = LottoDrawingMachine

    "당첨 통계와 수익률을 반환한다" {
        val winNumbers = listOf(1, 2, 3, 4, 5, 6)

        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 10, 11, 12).map { LottoNumber(it) }, 14000)
            )
        )

        val drawResult = sut.draw(winNumbers, lottos)
        drawResult.rankPrizes.size shouldBe 1
        drawResult.totalRoi shouldBe "0.35"
    }
})
