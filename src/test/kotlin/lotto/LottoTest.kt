package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest : FreeSpec({
    "유효하지 않은 번호 개수를 입력하면 예외를 발생시킨다" - {
        listOf(
            emptyList(),
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7)
        ).forEach { numbers ->
            "입력값: $numbers" {
                shouldThrow<InvalidLottoNumberCountException> { Lotto(numbers) }
            }
        }
    }

    "유효하지 않은 번호 값을 입력하면 예외를 발생시킨다" - {
        listOf(
            listOf(0, 1, 2, 3, 4, 5),
            listOf(-1, 1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 46)
        ).forEach { numbers ->
            "입력값: $numbers" {
                shouldThrow<InvalidLottoNumberException> { Lotto(numbers) }
            }
        }
    }
})