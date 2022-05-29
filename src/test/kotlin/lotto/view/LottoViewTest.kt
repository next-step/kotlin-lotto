package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.extension.autoOf

internal class LottoViewTest : StringSpec({

    "구매한 로또 개수를 출력한다" {
        val lottos = List(5) { Lotto.autoOf(1, 2, 3, 4, 5, 6) }
        val output = StubOutput()
        val view = LottoView(output, lottos)

        view.print()

        output.printed.first() shouldBe "\n수동으로 0장, 자동으로 5개를 구매했습니다."
    }

    "구매한 로또의 숫자리스트를 출력한다" {
        val lottos = listOf(
            Lotto.autoOf(1, 2, 3, 4, 5, 6),
            Lotto.autoOf(7, 8, 9, 10, 11, 12),
        )
        val output = StubOutput()
        val view = LottoView(output, lottos)

        view.print()

        output.printed.drop(1) shouldBe listOf(
            "[1, 2, 3, 4, 5, 6]",
            "[7, 8, 9, 10, 11, 12]",
        )
    }
})
