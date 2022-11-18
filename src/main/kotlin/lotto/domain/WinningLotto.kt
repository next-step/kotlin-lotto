package lotto.domain

class WinningLotto(val numbers: Set<Int>) {
    init {
        require(numbers.size == Lotto.LOTTO_NUMBER_COUNT) { "로또 당첨 번호는 6개입니다." }
        require(numbers
            .filterNot { num -> num in Lotto.LOTTO_NUMBER_RANGE_START until Lotto.LOTTO_NUMBER_RANGE_END + 1 }
            .isNullOrEmpty()) {
            "로또 번호는 1부터 ${Lotto.LOTTO_NUMBER_RANGE_END}까지 입니다."
        }
    }
}
