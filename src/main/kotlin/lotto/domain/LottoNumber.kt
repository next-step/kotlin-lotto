package lotto.domain

data class LottoNumber(val number: Int) {

    init {
        require(number >= LottoMachine.MINIMIUM_LOTTO_NUMBER && number <= LottoMachine.MAXIMIUM_LOTTO_NUMBER) {
            "로또 숫자는 ${LottoMachine.MINIMIUM_LOTTO_NUMBER }보다 작고 ${LottoMachine.MAXIMIUM_LOTTO_NUMBER}보다 크면 안됨"
        }
    }
}
