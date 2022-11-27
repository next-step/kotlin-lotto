package lotto

class LottoMachine {
    fun draw(): LottoNumbers {
        var result = mutableSetOf<LottoNumber>()

        while(result.size < 6) {
            result.add(LottoNumber())
        }
        return LottoNumbers(result.toMutableList())
    }
}