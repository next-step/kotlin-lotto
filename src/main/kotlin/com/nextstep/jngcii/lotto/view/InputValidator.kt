package com.nextstep.jngcii.lotto.view

object InputValidator {
    private const val LOTTO_PRICE = 1_000

    fun validateInputCount(input: String?): Int? {
        val value = input.checkIsNull() ?: return null
        val count = value.checkIsIntAndTransform() ?: return null
        val positiveCount = count.checkNegative() ?: return null
        return positiveCount / LOTTO_PRICE
    }

    fun validateInputNumbers(input: String?): List<Int>? {
        val value = input.checkIsNull() ?: return null
        return value.split(",").map {
            it.checkIsIntAndTransform() ?: return null
        }
    }

    private fun String.checkIsIntAndTransform() =
        runCatching {
            this.trim().toInt()
        }.getOrElse {
            println("정수만 입력 가능합니다. 다시 입력해주세요.")
            null
        }

    private fun String?.checkIsNull() =
        if (this == null) {
            println("입력값이 없습니다. 다시 입력해주세요.")
            null
        } else {
            this
        }

    private fun Int.checkNegative() =
        if (this < 0) {
            println("양의 정수만 입력 가능합니다. 다시 입력해주세요.")
            null
        } else {
            this
        }
}
