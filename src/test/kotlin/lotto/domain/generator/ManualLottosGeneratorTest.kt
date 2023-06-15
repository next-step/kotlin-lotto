package lotto.domain.generator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import lotto.domain.request.LottoOrderRequest

class ManualLottosGeneratorTest : FunSpec({
    val manualLottosGenerator = ManualLottosGenerator

    test("유효한 로또 번호 목록을 전달하면 정상적인 로또 일급 컬렉션을 생성해 반환한다.") {
        val items = buildList {
            add(listOf("1", "2", "3", "4", "5", "6"))
            add(listOf("2", "3", "4", "5", "6", "7"))
            add(listOf("3", "4", "5", "6", "7", "8"))
            add(listOf("4", "5", "6", "7", "8", "9"))
        }

        val request = LottoOrderRequest(manualNumbersList = items, money = 4000)
        val actual = manualLottosGenerator.generate(value = request)

        actual.size shouldBe 4
        actual.forEachIndexed { idx, lotto ->
            items[idx].forEach {
                LottoNumber.valueOf(it.toInt()) shouldBeIn lotto
            }
        }
    }

    test("로또 번호 목록을 전달하지 않으면 내용이 없는 로또 일급 컬렉션을 반환한다.") {
        val request = LottoOrderRequest(manualNumbersList = emptyList(), money = 4000)

        val actual = manualLottosGenerator.generate(value = request)

        actual shouldHaveSize 0
    }
})
