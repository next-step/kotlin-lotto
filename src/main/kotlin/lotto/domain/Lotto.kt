package lotto.domain

import lotto.model.LottoNumber

class Lotto(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO) { "로또 번호는 ${NUMBER_OF_LOTTO}개의 숫자로 구성되어야 합니다." }
    }

    companion object {
        const val NUMBER_OF_LOTTO = 6
    }
}
