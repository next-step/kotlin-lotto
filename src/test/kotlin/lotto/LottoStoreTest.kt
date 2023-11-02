package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStore
import lotto.domain.LottoStore.buyLotto

class LottoStoreTest : FunSpec({

    test("로또 1장은 6개의 숫자를 가진다.") {
        val lotto = buyLotto()
        lotto.numbers.size shouldBe 6
    }

    test("로또 1장의 숫자는 1부터 45까지의 숫자이다.") {
        val lotto = buyLotto()
        lotto.numbers.forEach {
            it shouldBeInRange 1..45
        }
    }

    test("로또 1장의 숫자는 중복되지 않는다.") {
        val lotto = buyLotto()
        lotto.numbers.toSet().size shouldBe 6
    }

    test("로또 1장의 숫자는 오름차순으로 정렬되어 있다.") {
        val lotto = buyLotto()
        lotto.numbers shouldBe lotto.numbers.sorted()
    }

    test("입력 받은 금액만큼 로또를 구입할 수 있다.") {
        val inputPrice = 1000
        val lottos = LottoStore.buyLottos(inputPrice)
        lottos.size shouldBe 1
    }

    test("입력받은 금액이 로또 가격보다 낮으면 구매할 수 없다.") {
        val inputPrice = 500
        val exception = shouldThrow<RuntimeException> {
            LottoStore.buyLottos(inputPrice)
        }
        exception.message shouldBe "로또를 구매할 수 없습니다."
    }
})
