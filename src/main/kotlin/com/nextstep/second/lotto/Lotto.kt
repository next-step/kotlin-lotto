package com.nextstep.second.lotto

class Lotto(inputNumbers: List<Int>) {
    val numbers: List<Int>

    init {
        require(inputNumbers.size == LOTTO_NUMBER_SIZE) { "로또는 $LOTTO_NUMBER_SIZE 숫자만큼 번호를 입력하셔야 합니다" }
        this.numbers = inputNumbers
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
