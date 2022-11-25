package lotto.domain.lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.ticket.LottoTicket
import org.junit.jupiter.api.assertThrows

class LottoResultTest : FunSpec({
    context("로또 결과를 정상적으로 랜덤하게 생성한다") {
        withData(
            nameFn = { "$it" },
            (0..100).map {
                LottoNumber.randomShuffle(LottoTicket.TOTAL_COUNT_LOTTO_NUMBER)
                    .map { it.number }
            }
        ) { lottoResultNumberList ->
            val lottoResult = LottoResult(lottoResultNumberList)

            lottoResult shouldNotBe null
            lottoResult.lottoNumberList shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            lottoResult.lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
            lottoResult.lottoNumberList.map { it.number } shouldContainExactly lottoResultNumberList
        }
    }

    context("중복된 로또 결과 번호가 있을 경우, IllegalArgumentException") {
        withData(
            nameFn = { "$it" },
            listOf(
                listOf(1, 1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 1, 6),
                listOf(1, 2, 3, 4, 5, 5)
            )
        ) { invalidInput ->
            assertThrows<IllegalArgumentException> { LottoResult(invalidInput) }
        }
    }

    context("로또 결과 번호 갯수가 6개가 아닐 경우, IllegalArgumentException") {
        withData(
            nameFn = { "${it.size}개일 경우" },
            ((1..5) + (7..10)).map { lottoResultNumberCount ->
                LottoNumber.randomShuffle(lottoResultNumberCount)
                    .map { it.number }
            }
        ) { invalidInput ->
            assertThrows<IllegalArgumentException> { LottoResult(invalidInput) }
        }
    }
})
