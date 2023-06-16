package lotto.domain

class LottoNumber(val lottoNumber : List<Int>) {

    init {
        if(lottoNumber.size != lottoNumber.distinct().size) {
            throw IllegalArgumentException("중복된 숫자는 올 수 없음")
        }
        val minimium = LottoMachine.MINIMIUM_LOTTO_NUMBER
        val maximuim = LottoMachine.MAXIMIUM_LOTTO_NUMBER
        if(lottoNumber.any { it < minimium || it > maximuim }) {
            throw IllegalArgumentException("${minimium}보다 작고 ${maximuim}보다 큰 숫자는 올 수 없음")
        }
    }
}
