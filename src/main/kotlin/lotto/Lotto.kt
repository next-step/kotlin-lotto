package lotto

class Lotto {
    val numbers: List<Int>
        get() = _numbers
    private val _numbers = arrayListOf<Int>()

    fun processLotto(lottoNumbers: List<Int>) {
        _numbers.clear()
        _numbers.addAll(lottoNumbers)
    }
}
