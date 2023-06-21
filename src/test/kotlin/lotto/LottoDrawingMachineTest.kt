package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoDrawingMachineTest : StringSpec({
    val sut = LottoDrawingMachine

    "당첨 통계와 수익률을 반환한다" {
        val winNumbers = LottoNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumbers = LottoNumber.of(listOf(7))

        val lottos = Lottos(
            listOf(
                Lotto(LottoNumber.of(listOf(1, 2, 3, 10, 11, 12)), 14000)
            )
        )

        val drawResult = sut.draw(WinningLotto(winNumbers, bonusNumbers), lottos)
        drawResult.totalRoi shouldBe "0.35"
    }
})
