package lotto

class LottoMachine {
    fun draw(): MutableList<LottoNumber> {
        val result = mutableListOf<LottoNumber>()
        for(i in 1..6) {
            result.add(LottoNumber())
        }
        result.sort()
        return result
    }
}