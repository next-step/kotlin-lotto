package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Order

class OrderTest : StringSpec({
    "주문이 생성되면 전달된 금액에 맞는 로또를 소지한다." {
        val lottoNumbers =
            setOf(
                LottoNumber.getNumber(1),
                LottoNumber.getNumber(2),
                LottoNumber.getNumber(3),
                LottoNumber.getNumber(4),
                LottoNumber.getNumber(5),
                LottoNumber.getNumber(6),
            )
        val lottos =
            listOf(
                Lotto(lottoNumbers),
                Lotto(lottoNumbers),
                Lotto(lottoNumbers),
                Lotto(lottoNumbers),
                Lotto(lottoNumbers),
            )

        val order = Order(5000, lottos)

        order.lottos.size shouldBe 5
    }

    "주문 생성 시 전달된 금액과 로또의 수량이 맞지 않을 경우 예외를 반환한다." {

        assertSoftly {
            shouldThrow<IllegalArgumentException> { Order(10000, listOf(Lotto(setOf(LottoNumber.getNumber(1))))) }
            shouldThrow<IllegalArgumentException> {
                Order(
                    10000,
                    listOf(
                        createLotto(1, 2, 3, 4, 5, 6),
                        createLotto(1, 2, 3, 7, 8, 9),
                    ),
                )
            }
        }
    }
})
