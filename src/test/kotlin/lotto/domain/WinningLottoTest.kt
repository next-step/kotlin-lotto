package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : FunSpec({

    test("보너스볼은 당첨번호와 중복될수 없다.") {
        val exception = shouldThrow<IllegalArgumentException> {
            WinningLotto(
                Lotto(
                    listOf(1, 2, 3, 4, 5, 6)
                        .map { LottoNumber(it) }
                ),
                LottoNumber(6)
            )
        }
        exception.message shouldBe "보너스 볼은 당첨 번호와 중복될 수 없습니다."
    }
})
