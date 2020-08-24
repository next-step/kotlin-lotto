package lotto.domain

class AutoLotto private constructor(numbers: List<Int>) : Lotto(numbers) {
    constructor() : this(
        LOTTO_NUMBERS.shuffled().subList(0, COUNT_OF_NUMBERS)
    )
}
