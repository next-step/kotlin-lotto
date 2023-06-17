import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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
})
