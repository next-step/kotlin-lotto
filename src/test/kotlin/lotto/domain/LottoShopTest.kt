package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({

    "금액을 입력하면 로또 티켓의 수가 반환된다." {
        LottoShop.getTicketCount(10000) shouldBe 10
    }

    "잘못된 금액을 입력하면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            LottoShop.getTicketCount(10030)
        }.message shouldBe "1000원 단위로 입력해주세요."
    }

    "금액을 입력하면 로또티켓들이 반환된다." {
        with(LottoShop.getAutoLottos(5000)) {
            list.size shouldBe 5
            list[0].numbers.distinct().size shouldBe 6
            list[0].lottoType shouldBe LottoType.AUTO
        }
    }

    "수동 번호를 로또샵에 전달하면 로또티켓들이 반환된다." {
        with(
            LottoShop.getManualLottos(
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                )
            )
        ) {
            list.size shouldBe 1
            list[0].lottoType shouldBe LottoType.MANUAL
        }
    }

    "금액과 수동번호를 전달하면 금액에 맞는 수동,자동 로또티켓들이 반환된다." {
        with(
            LottoShop.getLottos(
                10000,
                listOf(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(2, 3, 4, 5, 6, 7)
                )
            )
        ) {
            list.size shouldBe 10
        }
    }
})
