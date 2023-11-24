package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoCreateMachine
import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.vo.Price

/**
 * 로또 생성 테스트
 * */
class LottoCreateTest: StringSpec({

    "구입금액을 로또가격으로 나눴을때 나머지가 0보다 크지 않으면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoCreateMachine.buyLottoList(BuyPrice(3300), Price(1000))
        }
    }
    "구입금액을 로또가격으로 나눴을때 NaN가 나오면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoCreateMachine.buyLottoList(BuyPrice(0), Price(1))
        }
    }
    "구입금액을 로또가격으로 나눴을때 Infinite가 나오면 IllegalArgumentException 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            LottoCreateMachine.buyLottoList(BuyPrice(1), Price(0))
        }
    }
    "구입금액 3000원을 로또가격 1000원으로 나눴을때 3개의 사이즈를 가진 로또 리스트가 생성되어야 한다." {
        val lottoList = LottoCreateMachine.buyLottoList(BuyPrice(3000), Price(1000))
        lottoList.size shouldBe 3
    }
})
