package lotto

data class LottoNumber(private val number: Int) {

    init {
        require(number in (1..45)){
            "로또 번호는 1~45의 숫자만 생성이 가능합니다"
        }
    }
}
