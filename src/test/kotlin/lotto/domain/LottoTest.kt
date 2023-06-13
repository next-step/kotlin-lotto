package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldContainExactly
import lotto.fixture.LottoNumbersFixtureMaker.createLottoNumbers

class LottoTest : FunSpec({
    val mixLottoNumbers = createLottoNumbers(30, 3, 4, 42, 22, 19)

    test("로또는 유효한 로또 번호 목록을 전달받으면 정상적으로 생성된다.") {
        val actual = Lotto(mixLottoNumbers)

        mixLottoNumbers.forEach {
            it shouldBeIn actual.lottoNumbers
        }
    }

    test("로또는 유효하지 않은 로또 번호 목록을 전달받으면 예외를 던진다.") {
        val invalidLottoNumbers = listOf(
            createLottoNumbers(30, 3, 4, 42, 22),
            createLottoNumbers(30, 3, 4, 42, 22, 23, 24)
        )

        invalidLottoNumbers.forEach {
            shouldThrow<IllegalArgumentException> { Lotto(it) }
        }
    }

    test("전달된 로또 번호는 오름차순으로 정렬 된다.") {
        val actual = Lotto(mixLottoNumbers)
        val expected = mixLottoNumbers.sorted()

        expected shouldContainExactly actual.lottoNumbers
    }
})
