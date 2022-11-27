package lotto

class LottoMachine {
    fun draw(): LottoNumbers {
        val result = mutableSetOf<LottoNumber>()

        while(result.size < 6) {
            result.add(LottoNumber())
        }
        return LottoNumbers(result.toMutableList())
    }
}