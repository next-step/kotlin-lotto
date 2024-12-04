package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BoughtMoneyTest : StringSpec({

    "구입 금액을 생성한다." {
        BoughtMoney(1000)
    }

    "구입 금액이 음수라면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("구입 금액은 유효한 양수로 입력해야합니다.") {
            BoughtMoney(-1000)
        }
    }

    "자동 로또 구입 갯수를 계산한다." {
        forAll(
            row(BoughtMoney(1000), ManualLottoAmount(0), 1),
            row(BoughtMoney(1000), ManualLottoAmount(1), 0),
            row(BoughtMoney(1500), ManualLottoAmount(0), 1),
            row(BoughtMoney(1500), ManualLottoAmount(1), 0),
            row(BoughtMoney(10000), ManualLottoAmount(2), 8),
        ) { boughtMoney, manualLottoAmount, expected ->
            boughtMoney.calculateAutoLottoAmount(manualLottoAmount) shouldBe expected
        }
    }
})
