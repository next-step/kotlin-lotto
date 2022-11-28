package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize

class LottoStoreTest : StringSpec({
    val lottoStore = LottoStore(LottoMachine)

    "1,000 미만으로 로또 구입할땐 예외가 발생한다." {
        val cash = Cash(10)

        shouldThrow<IllegalArgumentException> {
            lottoStore.pay(cash)
        }
    }

    "로또 한장의 가격은 1,000 원이다." {
        forAll(
            row(Cash(1_000), 1),
            row(Cash(12_000), 12),
            row(Cash(14_000), 14),
        ) { cash, lottoCount ->
            val (lottos, _) = lottoStore.pay(cash)
            lottos.lottoList shouldHaveSize lottoCount
        }
    }
})
