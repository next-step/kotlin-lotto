package lottoTest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.WinningLotto

data class WinningLottoTestData(
    val lotto: Lotto,
    val bonusNumber: Int,
)

class WinningLottoTest : FunSpec({
    context("로또 번호와 보너스 번호는 중복될 수 없음") {
        withData(
            listOf(
                WinningLottoTestData(
                    Lotto(
                        listOf(1, 2, 3, 4, 5, 6)
                    ),
                    6
                )
            )
        ) { (lotto, bonusNumber) ->
            val exception = shouldThrow<IllegalArgumentException> {
                WinningLotto(lotto, bonusNumber)
            }
            exception.message shouldBe "Duplicated number is in lotto!"
        }
    }

    context("보너스 번호는 로또 번호의 범위를 벗어날 수 없음") {
        withData(
            listOf(
                WinningLottoTestData(
                    Lotto(
                        listOf(1, 2, 3, 4, 5, 6)
                    ),
                    50
                )
            )
        ) { (lotto, bonusNumber) ->
            val exception = shouldThrow<IllegalArgumentException> {
                WinningLotto(lotto, bonusNumber)
            }
            exception.message shouldBe "Invalidate bonus number!"
        }
    }
})
