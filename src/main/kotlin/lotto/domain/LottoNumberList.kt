package lotto.domain

class LottoNumberList(inputNumberList: List<Int>) {

    val numberList: List<Int> = inputNumberList.sorted()

    init {
        require(numberList.all { it in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }

        require(numberList.size == Lotto.NUMBER_COUNT_MAX) { "로또 번호는 6개만 가능합니다." }

        require(numberList.distinct().size == numberList.size) { "로또 번호는 중복될 수 없습니다." }
    }
}