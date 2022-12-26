package lotto.domain

class LottoNumber(
    number: Int
) {

    init {
        require(number in 1..43) {
            "로또 숫자는 1이상 43이하만 가능해요."
        }
    }
}
