package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import lotto.domain.order.PurchaseOrder

class LottoResultTest: DescribeSpec({

    describe(name = "로또 결과를 구매 주문과 당첨 복권으로 생성할 수 있다.") {
        val purchaseOrder = PurchaseOrder(amount = 10000)


        context(name = "구매한 복권이 있으면 당첨된 결과를 알 수 있다.") {

            it(name = "당첨 통계를 알 수 있다.") {

            }

            it(name = "수익률을 알 수 있다.") {

            }
        }

        context(name ="구매한 복권이 없으면 당첨 결과가 비어있다.") {

            it(name = "당첨 통계가 비어 있다.") {

            }

            it(name = "수익률이 0.0으로 반환된다.") {

            }
        }
    }
})
