package com.nextstep.jngcii.lotto.service

object InputValidator {
    fun validateNotNull(input: String?): String {
        require(input != null) { "입력값이 null일 수 없습니다." }
        return input
    }

    fun validateInt(input: String): Int {
        return runCatching {
            input.toInt()
        }.getOrElse {
            throw IllegalArgumentException("정수만 입력 가능합니다.")
        }
    }

    fun validatePositive(input: Int): Int {
        require(input > 0) { "양의 정수만 입력 가능합니다." }
        return input
    }
}
