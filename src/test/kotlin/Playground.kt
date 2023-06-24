import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber

class Playground : StringSpec({
    "runCatching / 정상 실행 시 getOrNull을 실행하면 정상적인 값이 반환 된다." {
        val runCatching = runCatching { "1".toInt() }
            .onSuccess { println("runCatching onSuccess") }
            .onFailure { println("runCatching onFail") }
            .also { println("This is similar to finally of try-catch") }

        runCatching.getOrThrow() shouldBe 1
    }

    "runCatching / 에러 발생 시 getOrNull을 실행하면 null이 반환 된다." {
        val runCatching = runCatching { "-".toInt() }
            .onSuccess { println("runCatching onSuccess") }
            .onFailure { println("runCatching onFail") }
            .also { println("This is similar to finally of try-catch") }

        runCatching.getOrNull() shouldBe null
    }


    "SortedSet" {
        val list = listOf(
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(5),
            LottoNumber(5),
            LottoNumber(4),
            LottoNumber(2),
            LottoNumber(1),
            LottoNumber(2),
        )
        val toHashSet = list.toHashSet()
        println(toHashSet)
        println(list.toSortedSet())
    }


})
