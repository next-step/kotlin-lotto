package lotto.domain

class Lotto(val numbers: List<Int>) {
    init {
        isNumbersOver6()
        isNumbersDistinct()
        numbers.forEach {
            isNumberRange1To45(it)
        }
    }
    private fun isNumbersOver6(){
        if (numbers.size != 6) {
            throw IllegalArgumentException("로또는 6개의 숫자로 이루어져 있습니다.");
        }
    }

    private fun isNumbersDistinct() {
        val distinct = numbers.distinct()
        if (numbers.size != distinct.size){
            throw IllegalArgumentException("로또 번호는 다른 숫자로 이루어져야합니다.");
        }
    }

    private fun isNumberRange1To45(number: Int){
        if (number < 1 || number > 45) throw IllegalArgumentException("로또 번호는 1에서 45 사이 숫자이어야합니다.")
    }
}
