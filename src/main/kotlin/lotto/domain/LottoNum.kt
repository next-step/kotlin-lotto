package lotto.domain

class LottoNum(num: Int) {
    val num: Int

    init {
        require(num in 1..45) {
            "로또 숫자 범위는 1 ~ 45 입니다."
        }

        this.num = num
    }
}
