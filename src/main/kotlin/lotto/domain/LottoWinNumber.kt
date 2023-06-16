package lotto.domain

class LottoWinNumber(val winNumbers : List<Int>) {

    init {
        if(winNumbers.size != winNumbers.distinct().size) {
            throw IllegalArgumentException("중복된 숫자는 올 수 없음")
        }
        if(winNumbers.any { it < LottoMachine.MINIMIUM_LOTTO_NUMBER || it > LottoMachine.MAXIMIUM_LOTTO_NUMBER }) {
            throw IllegalArgumentException("1보다 작고 45보다 큰 숫자는 올 수 없음")
        }
    }
}


    
