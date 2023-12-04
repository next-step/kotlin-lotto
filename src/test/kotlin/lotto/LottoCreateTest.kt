package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.AutoLottoCreateMachine
import lotto.domain.model.BuyPrice
import lotto.domain.model.Price

/**
 * 로또 생성 테스트
 * */
class LottoCreateTest : StringSpec({

    "구입금액을 로또가격으로 나눴을때 나머지가 0이 아니면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            AutoLottoCreateMachine.buyAutoLottoList(0, BuyPrice(3300), Price(1000))
        }
    }

    "구입금액을 로또가격으로 나눴을때 NaN가 나오면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            AutoLottoCreateMachine.buyAutoLottoList(0, BuyPrice(0), Price(1))
        }
    }

    "구입금액을 로또가격으로 나눴을때 Infinite가 나오면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            AutoLottoCreateMachine.buyAutoLottoList(0, BuyPrice(1), Price(0))
        }
    }

    "수동으로 구입한 로또가 4개고 구입금액 3000원을 로또가격 1000원으로 나눴을때의 값이 수동으로 구입한 로또의 개수보다 작아서 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            AutoLottoCreateMachine.buyAutoLottoList(4, BuyPrice(3000), Price(1000))
        }
    }

    "수동으로 구입한 로또가 1개고 구입금액 3000원을 로또가격 1000원으로 나눴을때 2개의 사이즈를 가진 로또 리스트가 생성되어야 한다." {
        val lottoList = AutoLottoCreateMachine.buyAutoLottoList(1, BuyPrice(3000), Price(1000))
        lottoList.size shouldBe 2
    }

    "수동으로 구입한 로또가 1개고 구입금액 4000원을 로또가격 1000원으로 나눴을때 3개의 사이즈를 가진 로또 리스트가 생성되어야 한다." {
        val lottoList = AutoLottoCreateMachine.buyAutoLottoList(1, BuyPrice(4000), Price(1000))
        lottoList.size shouldBe 3
    }
})
