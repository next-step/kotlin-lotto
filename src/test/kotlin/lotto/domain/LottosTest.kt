package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class LottosTest : FreeSpec({

    "입력된 총 금액에 구입가능 금액만큼 나눠서 로또를 구매한다." - {
        listOf(
            row(1_000, 1),
            row(2_000, 2),
            row(5_500, 5),
            row(4_999, 4),
        ).forEach { (moneyValue, lottoCount) ->
            "'$moneyValue' 로는 '$lottoCount' 만큼 구매할 수 있다." {
                val money = Money(BigDecimal.valueOf(moneyValue.toLong()))
                val lottos = Lottos.buyLottos(money = money)

                lottos.values shouldHaveSize lottoCount
            }
        }
    }

    "구입가능 금액보다 적을 경우 예외가 발생한다." - {
        listOf(
            1,
            10,
            999
        ).forEach { moneyValue ->
            "'$moneyValue' 로는 로또를 구매할 수 없다." {
                val money = Money(BigDecimal.valueOf(moneyValue.toLong()))
                val exception = shouldThrowExactly<IllegalArgumentException> { Lottos.buyLottos(money = money) }
                exception.message shouldBe "로또 구입을 위한 최소 금액은 1000 입니다."
            }
        }
    }
})
