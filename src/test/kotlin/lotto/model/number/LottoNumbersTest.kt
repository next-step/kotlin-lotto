package lotto.model.number

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumbersTest {
    @Test
    fun `로또 번호는 6개여야 한다`() {
        val lottoNumbers = LottoNumbers.issuanceLottoNumbers()
        lottoNumbers.size shouldBe 6
    }

    @Test
    fun `로또 번호는 1 ~ 45 사이여야 한다`() {
        repeat(100) {
            val lottoNumbers = LottoNumbers.issuanceLottoNumbers()
            val lottoNumberRange = LottoNumbers.LOTTO_MIN_NUMBER..LottoNumbers.LOTTO_MAX_NUMBER
            val result =
                lottoNumbers.all {
                    it in lottoNumberRange
                }
            result shouldBe true
        }
    }

    @Test
    fun `로또 번호 중복 없이 발행`() {
        val lottoNumbers = LottoNumbers.issuanceLottoNumbers()
        val count = lottoNumbers.distinct().count()
        count shouldBe LottoNumbers.DEFAULT_LOTTO_COUNT
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3",
            "1",
            "1,2,3,4,5,6,7",
        ],
    )
    fun `로또 번호는 6개여야 한다2`(rawNumbers: String) {
        val numbers =
            rawNumbers.split(",")
                .map { it.toInt() }
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(numbers)
        }.apply {
            message shouldBe "로또 번호는 ${LottoNumbers.DEFAULT_LOTTO_COUNT}개여야 합니다."
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,5,46",
            "0,1,2,3,4,5",
        ],
    )
    fun `로또 번호는 1 ~ 45 사이여야 한다`(rawNumbers: String) {
        val numbers =
            rawNumbers.split(",")
                .map { it.toInt() }
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(numbers)
        }.apply {
            message shouldBe "로또 번호는 ${LottoNumbers.LOTTO_MIN_NUMBER} ~ ${LottoNumbers.LOTTO_MAX_NUMBER} 사이여야 합니다."
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,1,4,5,6",
            "1,2,3,3,3,3",
            "1,1,1,1,1,1",
            "1,2,3,4,5,5",
        ],
    )
    fun `로또 번호는 중복될 수 없다`(rawNumbers: String) {
        val numbers =
            rawNumbers.split(",")
                .map { it.toInt() }
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(numbers)
        }.apply {
            message shouldBe "로또 번호는 중복될 수 없습니다."
        }
    }
}
