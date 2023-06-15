package lotto.domain.generator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.request.LottoOrderRequest
import java.lang.IllegalArgumentException

class AutoLottosGeneratorTest : FunSpec({
    val autoLottosGenerator = AutoLottosGenerator

    test("돈이 충분할때 로또 일급 컬렉션을 정상적으로 생성한다.") {
        val actual = autoLottosGenerator.generate(request = LottoOrderRequest(money = 3000))

        actual.size shouldBe 3
        actual.forEach {
            it.lottoNumbers shouldHaveSize 6
        }
    }

    test("돈이 충분하지 않으면 예외를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            autoLottosGenerator.generate(request = LottoOrderRequest(money = 900))
        }
    }
})
