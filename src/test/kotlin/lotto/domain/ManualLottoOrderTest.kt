package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ManualLottoOrderTest : FreeSpec({

    "수동이 0개일시 수동 로또 번호를 넣으면 실패한다." {
        // given
        val inputManualCount = ManualCount(Money(2000), 0)
        val manualLotto =
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
            )
        // when
        val exception = shouldThrow<IllegalArgumentException> { ManualLottoOrder(inputManualCount, manualLotto) }
        // then
        exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
    }

    "수동이 2개일시 수동 로또 번호1개만 넣으면 실패한다." {
        // given
        val inputManualCount = ManualCount(Money(2000), 2)
        val manualLotto =
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
            )
        // when
        val exception = shouldThrow<IllegalArgumentException> { ManualLottoOrder(inputManualCount, manualLotto) }
        // then
        exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
    }

    "수동이 1개일시 수동 로또 번호를 넣으면 성공한다." {
        // given
        val inputManualCount = ManualCount(Money(2000), 1)
        val manualLotto =
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
            )
        // when
        val manualLottoOrder = ManualLottoOrder(inputManualCount, manualLotto)
        // then
        manualLottoOrder.lottos.size shouldBe 1
        manualLottoOrder.usedMoney.price shouldBe 1000
    }

    "수동이 1개일시 수동 로또 번호2개를 넣으면 실패한다." {
        // given
        val inputManualCount = ManualCount(Money(2000), 1)
        val manualLotto =
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
            )
        // when
        val exception = shouldThrow<IllegalArgumentException> { ManualLottoOrder(inputManualCount, manualLotto) }
        // then
        exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
    }

    "수동이 2개일시 수동 로또 번호2개를 넣으면 실패한다." {
        // given
        val inputManualCount = ManualCount(Money(2000), 2)
        val manualLotto =
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                ),
            )
        // when
        val manualLottoOrder = ManualLottoOrder(inputManualCount, manualLotto)
        // then
        manualLottoOrder.lottos.size shouldBe 2
        manualLottoOrder.usedMoney.price shouldBe 2000
    }
})
